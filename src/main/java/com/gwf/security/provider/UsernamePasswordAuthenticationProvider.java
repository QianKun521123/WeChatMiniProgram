package com.gwf.security.provider;

import com.gwf.security.token.UsernamePasswordAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author gwf
 * @Data 2024/8/2 上午9:11
 * 最终实际的认证
 **/
@RequiredArgsConstructor
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Qualifier("usernamePasswordDetailsServiceImpl")
    private final UserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            UsernamePasswordAuthenticationToken tokenReq = (UsernamePasswordAuthenticationToken) authentication;

            // 根据手机号码，查找登录人信息....
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenReq.getUsername());

            // 密码加密后比较是否匹配
            if(new BCryptPasswordEncoder().matches(userDetails.getPassword(), tokenReq.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }

            return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new BadCredentialsException("服务器异常请稍后再试");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
