package com.gwf.aspect;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
    private static final Logger logger = LogManager.getLogger(DuplicateSubmitAspect.class);

    /**
     * 防重复提交切点
     */
//    @Pointcut("@annotation(preventDuplicateSubmit)")
//    public void preventDuplicateSubmitPointCut(PreventDuplicateSubmit preventDuplicateSubmit) {
//        log.info("定义防重复提交切点");
//    }

}
