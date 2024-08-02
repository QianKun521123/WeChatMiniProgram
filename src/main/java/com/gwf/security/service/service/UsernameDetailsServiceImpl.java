package com.gwf.security.service.service;

import com.gwf.entity.sys.Account;
import com.gwf.mapper.sys.AccountMapper;
import com.gwf.security.LoginUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @Author gwf
 * @Data 2024/8/1 下午5:57
 * 实现登录验证的逻辑业务层
 **/
@Service
@RequiredArgsConstructor
public class UsernameDetailsServiceImpl implements UserDetailsService {

    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 校验账户存在

        // 校验账户状态是否封禁

        //

        // 返回用户信息
        Account user = new Account();
        return LoginUserInfo.builder()
                .userId(user.getId())
                .username(user.getName())
                .password(new BCryptPasswordEncoder().encode("admin"))
                .user(user)
                .permissions(new HashSet<>())
                .build();
    }
}
