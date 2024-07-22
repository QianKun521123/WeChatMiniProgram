package com.gwf.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author gwf
 * @Data 2024/7/22 下午3:55
 * http状态码类
 **/
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    LOGIN_AUTH(208, "未登录"),
    AUTH_VALID_ERROR(8000, "未登录, 请登录");

    private final int code;
    private final String msg;
}
