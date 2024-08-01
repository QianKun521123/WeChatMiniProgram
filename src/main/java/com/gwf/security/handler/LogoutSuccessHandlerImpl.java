package com.gwf.security.handler;

import com.alibaba.fastjson2.JSONObject;
import com.gwf.model.result.Result;
import com.gwf.security.LoginUserInfo;
import com.gwf.security.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author gwf
 * @Data 2024/8/1 下午5:32
 * 自定义退出处理类 返回成功
 **/
@Configuration
@RequiredArgsConstructor
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    private final TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        LoginUserInfo loginUser = tokenService.getLoginUser(request);
        if (Objects.nonNull(loginUser)) {
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }

        Result result = new Result();
        result.setCode(200);
        result.setMsg("退出成功");

        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
