package com.gwf.service.sys.impl;

import cn.hutool.captcha.generator.CodeGenerator;
import com.gwf.config.WeChatMiniProgramConfig;
import com.gwf.config.captcha.CaptchaProperties;
import com.gwf.model.converter.sys.WeChatMiniProgramConfigConverter;
import com.gwf.model.vo.sys.CaptchaVo;
import com.gwf.model.vo.sys.WeChatMiniProgramConfigVo;
import com.gwf.service.sys.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author gwf
 * @Data 2024/7/22 下午2:34
 * 基础,不便归类,配置类业务层
 **/
@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {

    private final WeChatMiniProgramConfig weChatMiniProgramConfig;
    private final WeChatMiniProgramConfigConverter weChatMiniProgramConfigConverter;


    private final RedisTemplate<String,Object> redisTemplate;
    private final CaptchaProperties captchaProperties;
    private final CodeGenerator codeGenerator;

    /**
     * 获取系统信息
     *
     * @return 系统说明类信息
     */
    @Override
    public WeChatMiniProgramConfigVo BaseSysInfo() {
        return weChatMiniProgramConfigConverter.entityToVo(weChatMiniProgramConfig);
    }

    /**
     * 获取验证码
     *
     * @return 封装的验证码信息
     */
    @Override
    public CaptchaVo getCaptcha() {

        return null;
    }
}
