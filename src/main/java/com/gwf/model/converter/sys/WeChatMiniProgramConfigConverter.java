package com.gwf.model.converter.sys;

import com.gwf.config.WeChatMiniProgramConfig;
import com.gwf.model.vo.sys.WeChatMiniProgramConfigVo;
import org.mapstruct.Mapper;

/**
 * @Author gwf
 * @Data 2024/7/23 上午10:54
 * 系统信息转换
 **/
@Mapper(componentModel = "spring")
public interface WeChatMiniProgramConfigConverter {
    WeChatMiniProgramConfigVo entityToVo(WeChatMiniProgramConfig weChatMiniProgramConfig);
}
