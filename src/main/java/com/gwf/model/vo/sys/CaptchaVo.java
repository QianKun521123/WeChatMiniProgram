package com.gwf.model.vo.sys;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author gwf
 * @Data 2024/7/24 上午9:59
 * 验证码响应对象
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "验证码响应对象")
public class CaptchaVo {

    @Schema(description = "验证码缓存key")
    private String captchaKey;

    @Schema(description = "验证码图片Base64字符串")
    private String captchaBase64;
}
