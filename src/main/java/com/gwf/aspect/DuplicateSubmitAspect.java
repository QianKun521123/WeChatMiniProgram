package com.gwf.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author gwf
 * @Data 2024/7/24 上午10:33
 * 处理重复提交的切面
 **/
@Aspect
@Component
@RequiredArgsConstructor
public class DuplicateSubmitAspect {
}
