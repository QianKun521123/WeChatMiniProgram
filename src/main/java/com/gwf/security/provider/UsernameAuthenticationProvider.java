package com.gwf.security.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.gwf.security.token.UsernameAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author gwf
 * @Data 2024/8/2 上午9:11
 * 最终实际的认证
 **/
@RequiredArgsConstructor
public class UsernameAuthenticationProvider implements AuthenticationProvider {

    @Qualifier("usernameDetailsServiceImpl")
    private final UserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            UsernameAuthenticationToken tokenReq = (UsernameAuthenticationToken) authentication;

            // 根据手机号码，查找登录人信息....
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenReq.getUsername());

            // 密码加密后比较是否匹配
            if(new BCryptPasswordEncoder().matches(userDetails.getPassword(), tokenReq.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }

            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new BadCredentialsException("服务器异常请稍后再试");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernameAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
