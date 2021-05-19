package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {


    //这一步是获取application.properties中设置的发件人邮箱地址
    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        //发邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
        message.setFrom(username);
        //收件人邮件地址
        message.setTo("888888@QQ.com");
        //邮件主题
        message.setSubject("注册验证码二");
        //邮件正文
        message.setText("我是普通文本邮件内容");
        javaMailSender.send(message);
    }

}
