package com.gaofan.mqreids;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(value = SpringRunner.class)
@SpringBootTest
public class MqreidsApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Test
	public void testrabbitmq() {
		rabbitTemplate.convertAndSend("hello-java-exchange", "user", "user");
	}

	@Test
	public void testAmqpAdmin() {
		DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, true);
		amqpAdmin.declareExchange(directExchange);

		Queue queue = new Queue("hello-java-queue", true, false, false);
		amqpAdmin.declareQueue(queue);

		Binding binding = new Binding("hello-java-queue", Binding.DestinationType.QUEUE, "hello-java-exchange", "user", null);
		amqpAdmin.declareBinding(binding);

	}


	@Test
	public void contextLoads() {
		log.info("rabbitTemplate --> {}", rabbitTemplate);
		log.info("redisTemplate --> {}", redisTemplate);
		log.info("redissonClient --> {}", redissonClient);

	}

}
