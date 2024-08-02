package com.gwf.security.filter;

import cn.hutool.core.util.StrUtil;
import com.gwf.security.token.UsernamePasswordAuthenticationToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

/**
 * @Author gwf
 * @Data 2024/8/1 下午6:00
 * 用户密码登录过滤器
 **/
public class UsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String REQUEST_MATCHER = "POST";

    public UsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", REQUEST_MATCHER));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!request.getMethod().equals(REQUEST_MATCHER)) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        // 用户名称
        String username = getUsername(request);
        if (StrUtil.isEmpty(username)) {
            throw new AuthenticationServiceException("登录账号不能为空");
        }
        // 密码
        String password = getPassword(request);
        if (StrUtil.isEmpty(password)) {
            throw new AuthenticationServiceException("密码不能为空");
        }

        return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    private String getUsername(HttpServletRequest request) {
        return request.getHeader("username");
    }

    private String getPassword(HttpServletRequest request) {
        return request.getHeader("password");
    }


}
