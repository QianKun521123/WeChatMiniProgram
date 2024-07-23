package com.gwf.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author gwf
 * @Data 2024/7/23 下午2:04
 * 实体类基本数据(创建人/创建时间/修改人/修改时间)
 **/
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT) //是 MyBatis-Plus 中的注解，用于设置实体类中对应的字段在插入时需要自动填充。
    @JsonInclude(value = JsonInclude.Include.NON_NULL) //当前实体类在返回前端的时候忽略字段属性为null的字段，使其为null字段不显示。
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //日期格式化
    private LocalDateTime createTime;

    /**
     * 创建人ID
     */
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 修改人ID
     */
    private String updateBy;
}
