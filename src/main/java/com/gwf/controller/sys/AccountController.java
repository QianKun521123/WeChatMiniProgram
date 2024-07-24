package com.gwf.controller.sys;

import com.gwf.model.result.Result;
import com.gwf.service.sys.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gwf
 * @Data 2024/7/23 下午6:34
 * 账户控制层接口
 **/
@Tag(name = "2、账户控制层接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/account")
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/list")
    @Operation(summary = "2.1、获取信息列表")
    public Result list() {
        return Result.success(accountService.list());
    }

}
