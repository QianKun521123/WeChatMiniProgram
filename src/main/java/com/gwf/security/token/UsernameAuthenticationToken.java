package com.gwf.security.token;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @Author gwf
 * @Data 2024/8/1 下午5:39
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
