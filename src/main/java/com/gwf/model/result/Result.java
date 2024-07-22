package com.gwf.model.result;

import com.gwf.model.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @Author gwf
 * @Data 2024/7/22 下午3:47
 * 返回参数封装
 **/
@Data
public class Result<T> {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 系统消息
     */
    private String msg;
    /**
     * 请求数据的结果
     */
    private T data;


    public static <T> Result<T> success() {
        return success(null);
    }


    public static <T> Result<T>  success(T data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

}
