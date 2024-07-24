package com.gwf.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author gwf
 * @Data 2024/7/22 下午4:51
 * API文档 - swagger
 **/
@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WeChatMiniProgram的接口文档")
                        .description("这是基于knife4j-openapi3-jakarta-spring-boot-starter的接口文档")
                        .version("1.0")
                        .contact(new Contact()
                                .name("QianKun")
                                .email("2278417331@qq.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("微信小程序接口")
                        .url("http://localhost:3600"));

    }

    //    下面是分组
    @Bean
    public GroupedOpenApi groupedOpenApi1() {
        return GroupedOpenApi.builder()
                .group("微信小程序")
                .pathsToMatch("/**")
                .build();
    }

    //    下面是分组
    @Bean
    public GroupedOpenApi groupedOpenApi2() {
        return GroupedOpenApi.builder()
                .group("规划中")
                .pathsToMatch("/student/**")
                .build();
    }
}
