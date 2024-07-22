package com.gwf.model.result;

import com.gwf.model.enums.ResultCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author gwf
 * @Data 2024/7/22 下午3:47
 * 返回参数封装
 **/
@Data
@Schema(description ="统一返回格式")
public class Result<T> {

    @Schema(description ="返回码")
    private Integer code;

    @Schema(description ="系统消息")
    private String msg;

    @Schema(description ="请求数据的结果")
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
