package com.gwf.controller.sys;

import com.gwf.model.result.Result;
import com.gwf.service.sys.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gwf
 * @Data 2024/7/22 下午2:31
 * 基础响应控制层
 **/
@RestController
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @GetMapping("/")
    public Result BaseSysInfo() {
        return baseService.BaseSysInfo();
    }
}
