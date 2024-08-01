package com.gwf.security.service;

import cn.hutool.core.util.StrUtil;
import com.gwf.constants.CacheConstants;
import com.gwf.security.LoginUserInfo;
import com.gwf.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author gwf
 * @Data 2024/8/1 下午1:56
 * token验证业务处理
 **/
@Slf4j
@Getter
@Setter
@Component
@RequiredArgsConstructor
public class TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;


    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;



    private final RedisUtils redisCache;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUserInfo getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            try {
                Claims claims = parseToken(token);
                // 解析对应的权限以及用户信息
                String uuid = (String) claims.get(CacheConstants.LOGIN_USER_KEY);
                String userKey = getTokenKey(uuid);
                return redisCache.getCacheObject(userKey);
            } catch (Exception e) {
                log.error("getLoginUser缓存异常", e);
            }
        }
        return null;
    }

    /**
     * 获取请求token
     *
     * @param request 请求参数
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(CacheConstants.TOKEN_PREFIX)) {
            token = token.replace(CacheConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private String getTokenKey(String uuid) {
        return CacheConstants.LOGIN_TOKEN_KEY + uuid;
    }

    /**
     * 创建令牌
     *
     * @param loginUserInfo 用户信息
     * @return 令牌
     */
    public String createToken(LoginUserInfo loginUserInfo) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        loginUserInfo.setToken(token);
        refreshToken(loginUserInfo);
        Map<String, Object> claims = new HashMap<>();
        claims.put(CacheConstants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUserInfo 登录信息
     */
    public void refreshToken(LoginUserInfo loginUserInfo) {
        loginUserInfo.setLoginTime(System.currentTimeMillis());
        loginUserInfo.setExpireTime(loginUserInfo.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUserInfo.getToken());
        redisCache.setCacheObject(userKey, loginUserInfo, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUserInfo
     * @return 令牌
     */
    public void verifyToken(LoginUserInfo loginUserInfo) {
        long expireTime = loginUserInfo.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUserInfo);
        }
    }

    /**
     * 删除用户身份信息
     *
     * @param token token
     */
    public void delLoginUser(String token) {
        if (StrUtil.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }
}
