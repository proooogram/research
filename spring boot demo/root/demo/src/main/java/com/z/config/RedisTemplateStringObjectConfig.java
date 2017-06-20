package com.z.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by agui on 2017/6/20.
 */
@Configuration
public class RedisTemplateStringObjectConfig {

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplateSO")
    public RedisTemplate<String, Object> redisTemplateSO(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        template.setKeySerializer(new StringRedisSerializer());
        //如果没有这句话 key会变成 \xAC\xED\x00\x05t\x00\x07user002 这样的 set的key是user002

        return template;
    }
}
