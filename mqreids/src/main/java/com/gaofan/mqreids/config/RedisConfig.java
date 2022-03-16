package com.gaofan.mqreids.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author gaofan
 * @create 2021-05-09 14:34
 */
//@Configuration
public class RedisConfig {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @PostConstruct
    public void initReids() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.opsForValue().setIfAbsent("key", "value");
        redisTemplate.opsForHash().putIfAbsent("","","");
        Boolean delete = redisTemplate.delete("");
        Long execute = redisTemplate.execute(new DefaultRedisScript<>("", Long.class)
                , Arrays.asList("key"), "afaef");
        //redisTemplate.opsForHash().
    }

}
