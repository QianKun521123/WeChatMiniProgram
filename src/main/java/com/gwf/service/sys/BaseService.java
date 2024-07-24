package com.gwf.service.sys;

import com.gwf.model.vo.sys.CaptchaVo;
import com.gwf.model.vo.sys.WeChatMiniProgramConfigVo;

/**
 * @Author gwf
 * @Data 2024/7/22 下午2:33
 * 基础,不便归类,配置类接口
 **/
public interface BaseService {
    /**
     * 获取系统信息
     *
     * @return 系统说明类信息
     */
    WeChatMiniProgramConfigVo BaseSysInfo();

    /**
     * 获取验证码
     *
     * @return 封装的验证码信息
     */
    CaptchaVo getCaptcha();
}
