package com.bbtree.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public class TestinfoProducer {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmqpTemplate amqpTemplate = ap.getBean("amqpTemplate", RabbitOperations.class);
        for (int i = 0; i < 100000; i++) {
            amqpTemplate.convertAndSend("queue_one_key", "hello world" + i);
        }
        System.out.println("send is ok");
    }
}
