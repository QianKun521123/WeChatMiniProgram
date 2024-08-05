# WeChatMiniProgram
    WeChatMiniProgram是技术的综合使用,并且尝试独立微信小程序开发,主要包括后端java开发,前端H5(可能Vue),微信小程序三个方面.
## 主要技术记录
- springboot 3.3.2
- knife4j-openapi3-jakarta 4.5.0
- lombok 1.18.34
- MapStruct 1.5.3.Final
- dynamic-datasource 4.3.1
- lombok 1.18.34
- mybatis-plus 3.5.7
- mysql-connector 8.0.33
- hutool 5.8.29
- springboot-redis
- Log4j2 性能高于logback

[//]: # (- druid 1.2.23 性能不如HikariCP 所以弃用)
## 版本记录



Security
1.用户提登录信息
2.经UsernamePasswordAuthenticationFilter(Filter)登录信息封装为UsernamePasswordAuthenticationToken对象交给AuthenticationManager进行认证
3.AuthenticationManager 通过 UserDetailsService 获取用户信息，然后使用 PasswordEncoder 对用户密码进行校验。
4.如果密码正确，AuthenticationManager 会生成一个认证通过的 Authentication 对象，并返回给 UsernamePasswordAuthenticationFilter 过滤器。如果密码不正确，则 AuthenticationManager 抛出一个 AuthenticationException 异常。
5.UsernamePasswordAuthenticationFilter 将 Authentication 对象交给 SecurityContextHolder 进行管理，并调用 AuthenticationSuccessHandler 处理认证成功的情况。
6.如果认证失败，UsernamePasswordAuthenticationFilter 会调用 AuthenticationFailureHandler 处理认证失败的情况。
![1722820825418.jpg](..%2F..%2F..%2F..%2F..%2F..%2Fhome%2Fgwf%2Fthinclient_drives%2FF%3A%2F1722820825418.jpg)