package com.gwf.security.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @Author gwf
 * @Data 2024/8/1 下午5:39
 * 账户密码认证信息
 * 用户提交用户名密码，被安全过滤器链中的UsernamePasswordAuthenticationFilter过滤器拿到，并封装为请求Authentication，通常情况下是UsernamePasswordAuthenticationToken这个实现类
 **/
@Setter
@Getter
public class UsernameAuthenticationToken extends AbstractAuthenticationToken {

    private String username;

    private String password;

    private String code;

    public UsernameAuthenticationToken(String username, String password) {
        super(null);
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
