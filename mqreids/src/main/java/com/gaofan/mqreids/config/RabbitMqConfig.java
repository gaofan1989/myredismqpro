package com.gaofan.mqreids.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author gaofan
 * @create 2021-05-09 14:28
 */
@Slf4j
//@Configuration
public class RabbitMqConfig {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitmq() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
              log.info("ConfirmCallback-->correlationData-> {}, ack-> {}, cause-> {}", correlationData,ack, cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("ReturnCallback-->message-> {}, replyCode-> {}, replyText-> {}, exchange-> {}, routingKey", message,replyCode,replyText,exchange, routingKey);
            }
        });
    }

}
