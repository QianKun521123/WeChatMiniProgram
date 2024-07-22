package com.gwf.service.sys.impl;

import com.gwf.config.WeChatMiniProgramConfig;
import com.gwf.service.sys.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author gwf
 * @Data 2024/7/22 下午2:34
 **/
@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {

    private final WeChatMiniProgramConfig weChatMiniProgramConfig;

    @Override
    public String BaseSysInfo() {
        return weChatMiniProgramConfig.toString();
    }
}
