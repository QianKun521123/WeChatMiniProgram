package com.gwf.config.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;


/**
 * @Author gwf
 * @Data 2024/7/24 上午11:33
 * redis配置类, 使用fastJson序列化
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置key和value的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // 设置key的序列化器为StringRedisSerializer
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer()); // 设置value的序列化器为JdkSerializationRedisSerializer
        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // 设置hash key的序列化器为StringRedisSerializer
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer()); // 设置hash value的序列化器为JdkSerializationRedisSerializer
        redisTemplate.afterPropertiesSet(); // 初始化RedisTemplate
        return redisTemplate; // 返回配置好的RedisTemplate
    }

    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(limitScriptText());
        redisScript.setResultType(Long.class);
        return redisScript;
    }

    /**
     * 限流脚本
     */
    private String limitScriptText() {
        return "local key = KEYS[1]\n" +
                "local count = tonumber(ARGV[1])\n" +
                "local time = tonumber(ARGV[2])\n" +
                "local current = redis.call('get', key);\n" +
                "if current and tonumber(current) > count then\n" +
                "    return tonumber(current);\n" +
                "end\n" +
                "current = redis.call('incr', key)\n" +
                "if tonumber(current) == 1 then\n" +
                "    redis.call('expire', key, time)\n" +
                "end\n" +
                "return tonumber(current);";
    }
}
