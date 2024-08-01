package com.gwf.security.handler;

import com.alibaba.fastjson2.JSONObject;
import com.gwf.model.result.Result;
import com.gwf.security.LoginUserInfo;
import com.gwf.security.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author gwf
 * @Data 2024/8/1 下午2:02
 * 登录成功处理器
 **/
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final TokenService tokenService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        LoginUserInfo loginUserInfo = (LoginUserInfo) authentication.getPrincipal();

        String token = tokenService.createToken(loginUserInfo);

        Result result = new Result();
        result.setCode(200);
        result.setMsg("登录成功");
        result.setData(new HashMap<String, String>(1) {{
            put("token", token);
        }});

        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
