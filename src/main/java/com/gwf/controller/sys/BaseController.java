package com.gwf.controller.sys;

import com.gwf.model.result.Result;
import com.gwf.model.vo.sys.WeChatMiniProgramConfigVo;
import com.gwf.service.sys.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gwf
 * @Data 2024/7/22 下午2:31
 * 基础响应控制层
 **/
@Tag(name = "1、基础接口")
@RestController
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @GetMapping("/")
    @Operation(summary = "1.1、获取系统信息,部署验证")
    public Result<WeChatMiniProgramConfigVo> BaseSysInfo() {
        return Result.success(baseService.BaseSysInfo());
    }
}
