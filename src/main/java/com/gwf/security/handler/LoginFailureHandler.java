package com.gwf.security.handler;

import com.alibaba.fastjson2.JSONObject;
import com.gwf.model.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * @Author gwf
 * @Data 2024/8/1 上午10:55
 * 登录失败处理器
 **/
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception) throws IOException {

        Result result = new Result();
        result.setCode(402);
        result.setMsg(exception.getMessage());

        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
