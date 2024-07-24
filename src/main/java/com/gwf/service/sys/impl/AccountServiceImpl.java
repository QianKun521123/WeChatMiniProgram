package com.gwf.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gwf.entity.sys.Account;
import com.gwf.mapper.sys.AccountMapper;
import com.gwf.service.sys.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author gwf
 * @Data 2024/7/23 下午6:32
 **/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
