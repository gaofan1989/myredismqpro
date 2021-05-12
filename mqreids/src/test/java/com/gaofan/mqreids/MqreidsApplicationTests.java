package com.gaofan.mqreids;

import com.gaofan.mqreids.entity.User;
import com.gaofan.mqreids.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
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

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


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
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 默认：com.zaxxer.hikari.HikariDataSource 、 com.mysql.jdbc.JDBC4Connection
	 * druid: com.alibaba.druid.pool.DruidDataSource com.mysql.cj.jdbc.ConnectionImpl
	 */
	@Autowired
	private DataSource dataSource;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testmybatis() throws SQLException {
		UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
		log.info("sqlSessionTemplate获取mapper: --> {}", mapper.getClass());
		User user = userMapper.getById(1);
		log.info("user --> {}", user);

		log.info("数据源dataSource: --> {}", dataSource.getClass());
		Connection connection = dataSource.getConnection();
		log.info("数据库连接Connection: --> {}", connection);

	}

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
