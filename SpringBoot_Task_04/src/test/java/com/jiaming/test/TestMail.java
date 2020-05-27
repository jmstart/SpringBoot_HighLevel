package com.jiaming.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author jmstart
 * @create 2020-05-27 13:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {

    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * 发送简单邮件
     */
    @Test
    public void test01() {
        //创建一个简单消息邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //设置邮件信息
        mailMessage.setSubject("通知-今晚Happy");
        mailMessage.setText("今晚6：30聚会,全部都要参加。");
        //发去哪
        mailMessage.setTo("1355104838@163.com");
        //谁发的
        mailMessage.setFrom("1355104838@qq.com");

        //发送一个简单邮件
        mailSender.send(mailMessage);
    }

    /**
     * 发送复杂邮件
     */
    @Test
    public void test02() throws Exception{
        //创建复杂消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        messageHelper.setSubject("通知-今晚Happy");
        messageHelper.setText("<b>今晚6：30聚会,全部都要参加。</b>", true);
        messageHelper.setTo("1355104838@163.com");
        messageHelper.setFrom("1355104838@qq.com");

        //上传文件
        messageHelper.addAttachment("1.jpg", new File("C:\\Users\\jiami\\Pictures\\1.jpg"));

        //发送
        mailSender.send(mimeMessage);
    }
}
