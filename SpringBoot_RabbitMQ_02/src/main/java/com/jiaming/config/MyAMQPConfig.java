package com.jiaming.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jmstart
 * @create 2020-05-24 12:57
 */
@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messageConverter() {
        //配置发送消息到 RabbitMQ客户端显示json格式
        return new Jackson2JsonMessageConverter();
    }

}
