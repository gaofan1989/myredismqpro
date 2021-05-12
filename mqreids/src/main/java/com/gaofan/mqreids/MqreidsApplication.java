package com.gaofan.mqreids;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot只会引入自己的start： spring-boot-starter开头的:
 * spring-boot-starter-amqp/spring-boot-starter-data-redis
 * 不会引入spring-boot-starter结尾的：
 * 比如 mybatis-spring-boot-starter/redisson-spring-boot-starter/druid
 */
@EnableRabbit
@SpringBootApplication
public class MqreidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqreidsApplication.class, args);
	}

}
