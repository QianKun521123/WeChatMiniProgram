package com.gwf.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gwf.entity.sys.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author gwf
 * @Data 2024/7/23 下午2:02
 * 账户数据层接口类
 **/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
