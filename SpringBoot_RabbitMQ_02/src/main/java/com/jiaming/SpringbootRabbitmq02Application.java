package com.jiaming;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Rabbit自动配置
 *  1.RabbitAutoConfiguration
 *  2.RabbitProperties里面有所有的配置信息
 *  3.RabbitTemplate来接收和发送RabbitMQ消息
 *  4.@EnableRabbit + @RabbitListener 监听消息队列内容
 *  5.Amqpadmin:创建和删除 交换器(Exchange)、队列(Queue)、绑定规则(Binging)
 */
@EnableRabbit //开启基于注解的 RabbitMQ
@SpringBootApplication
public class SpringbootRabbitmq02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmq02Application.class, args);
    }

}
