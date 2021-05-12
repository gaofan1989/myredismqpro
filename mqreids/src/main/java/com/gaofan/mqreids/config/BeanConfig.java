package com.gaofan.mqreids.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaofan
 * @create 2021-05-09 14:41
 */
@Configuration
public class BeanConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    /**
     * MessageConverter 消息转化：json格式的
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * TODO
     * 1、需要手动引入 redisson的依赖：org.redisson
     * <groupId>org.redisson</groupId>
     * <artifactId>redisson-spring-boot-starter</artifactId>
     * <version>3.9.0</version>
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO)
                .setLockWatchdogTimeout(30000)
                .useSingleServer()
                //.setAddress("redis://192.168.52.132:6379")
                .setAddress(String.format("redis://%s:%s", redisHost,redisPort))
                .setTimeout(3000);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    public static void main(String[] args) {
        String format = String.format("redis://%s:%s", "192.168.56.133", "6379");
        System.out.println(format);//redis://192.168.56.132:6379
    }

}
