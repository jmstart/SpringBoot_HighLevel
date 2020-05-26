package com.jiaming.test;

import com.jiaming.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jmstart
 * @create 2020-05-24 12:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     *创建一个Exchange
     */
    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("Exchange创建完成");
    }

    /**
     *创建一个Queue
     */
    @Test
    public void createQueue() {
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
        System.out.println("Queue创建完成");
    }

    /**
     * 创建 Binging
     *  绑定 Exchange & Queue
     */
    @Test
    public void createBinging() {
        amqpAdmin.declareBinding(
                new Binding("amqpadmin.queue", //绑定队列
                        Binding.DestinationType.QUEUE, //队列类型
                        "amqpadmin.exchange", //绑定交换器
                        "amqp.jiaming",  //路由键
                        null)); //参数,没有写null

        System.out.println("绑定成功");
    }

    /**
     * 1.单播(点对点消息)
     */
    @Test
    public void contextLoads() {
        //添加三个参数,转换器 路由键 消息
        //消息需要自己去构造在序列化
        //rabbitTemplate.send();

        //常用这个方法, 这个的消息不用自己去构造序列化
        //rabbitTemplate.convertAndSend();
        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "jiaming.news", map);
    }

    /**
     * 接收消息
     */
    @Test
    public void receive() {

        Object receive = rabbitTemplate.receiveAndConvert("jiaming.news");
        System.out.println(receive.getClass());
        System.out.println(receive);
    }

    /**
     * 点对点 发送对象信息
     */
    @Test
    public void sendObject() {

        rabbitTemplate.convertAndSend("exchange.direct", "jiaming.news", new Book("仙逆","耳根"));
    }

    /**
     * 广播(群发)
     */
    @Test
    public void sendFanout() {

        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("民国谍影","寻青藤"));
    }

}
