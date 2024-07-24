package com.gwf.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author gwf
 * @Data 2024/7/24 上午10:24
 * 防止重复提交注解
 * @Inherited: 作用于某个类上，其子类是可以继承的该注解的
 * @Documented: 标记注解, 用于指示将被注解的元素包含在生成的Java文档中
 * @Target(ElementType.METHOD): 指定注解的目标
 * 1.CONSTRUCTOR:用于描述构造器
 * 2.FIELD:用于描述域
 * 3.LOCAL_VARIABLE:用于描述局部变量
 * 4.METHOD:用于描述方法
 * 5.PACKAGE:用于描述包
 * 6.PARAMETER:用于描述参数
 * 7.TYPE:用于描述类、接口(包括注解类型) 或enum声明）
 * @Retention(RetentionPolicy.RUNTIME): 指定注解的生命周期
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 **/
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreventDuplicateSubmit {
    /**
     * 防重提交锁过期时间(秒)
     * 默认5秒内不允许重复提交
     */
    int expire() default 5;
}
