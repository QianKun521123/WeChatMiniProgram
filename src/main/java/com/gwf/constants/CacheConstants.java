package com.gwf.constants;

/**
 * @Author gwf
 * @Data 2024/7/26 下午12:58
 * 缓存常量
 **/
public interface CacheConstants {

    /** 验证码缓存前缀 */
    String CAPTCHA_CODE_KEY = "captcha_code:";



    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";


    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

}

