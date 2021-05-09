package com.gaofan.mqreids;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MqreidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqreidsApplication.class, args);
	}

}
