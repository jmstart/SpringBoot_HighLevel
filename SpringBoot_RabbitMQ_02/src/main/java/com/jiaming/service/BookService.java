package com.jiaming.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jiaming.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author jmstart
 * @create 2020-05-25 9:12
 *
 * @RabbitListener
 *  被监听之后在浏览器客户端就看不到队列信息了,信息都会被提取到控制台
 */
@Service
public class BookService {

    //监听消息队列
    @RabbitListener(queues = "jiaming.news")
    public void receive(Book book) {
        System.out.println("收到消息: " + book);
    }

    //获得消息头
    @RabbitListener(queues = "xiaoming.news")
    public void receiveMessageHead(Message message) {
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }

}
