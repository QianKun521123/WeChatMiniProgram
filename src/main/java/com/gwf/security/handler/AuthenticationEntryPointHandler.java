package com.gwf.security.handler;

import com.alibaba.fastjson2.JSONObject;
import com.gwf.model.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/**
 * @Author gwf
 * @Data 2024/8/1 下午5:35
 * 认证失败处理器
 **/
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        Result result = new Result();
        result.setCode(401);
        result.setMsg("身份认证失败，请重新登录");

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }

}
