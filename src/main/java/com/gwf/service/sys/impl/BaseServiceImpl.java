package com.gwf.service.sys.impl;

import com.gwf.config.WeChatMiniProgramConfig;
import com.gwf.model.converter.sys.WeChatMiniProgramConfigConverter;
import com.gwf.model.vo.sys.WeChatMiniProgramConfigVo;
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

    private final WeChatMiniProgramConfigConverter weChatMiniProgramConfigConverter;

    @Override
    public WeChatMiniProgramConfigVo BaseSysInfo() {
        return weChatMiniProgramConfigConverter.entityToVo(weChatMiniProgramConfig);
    }
}
