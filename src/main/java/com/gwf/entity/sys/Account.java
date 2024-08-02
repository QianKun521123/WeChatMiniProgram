package com.gwf.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author gwf
 * @Data 2024/7/23 下午2:00
 * 账户实体类
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("account")
public class Account {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 主键
     */
    private String name;

}
