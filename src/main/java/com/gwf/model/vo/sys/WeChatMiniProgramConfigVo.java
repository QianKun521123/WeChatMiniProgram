package com.gwf.model.vo.sys;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Author gwf
 * @Data 2024/7/22 下午4:16
 * 系统配置类的传输对象
 **/
@Data
@Schema(description ="系统信息响应对象")
public class WeChatMiniProgramConfigVo{
    @Schema(description = "项目名称")
    private String name;

    @Schema(description = "版本")
    private String version;

    @Schema(description = "项目创建时间")
    private String createTime;

    @Schema(description = "使用的技术和版本")
    private List technicalVersion;
}
