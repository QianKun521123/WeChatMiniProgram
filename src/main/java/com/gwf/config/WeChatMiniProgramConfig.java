package com.gwf.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author gwf
 * @Data 2024/7/22 下午12:42
 * 项目配置类
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wmp")
public class WeChatMiniProgramConfig {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 项目创建时间
     */
    private String createTime;

    /**
     * 使用的技术和版本
     */
    private List<String> technicalVersion;
}
