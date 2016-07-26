package com.bbtree.srpingmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/20.
 */
public class QueuInfoProducer {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        AmqpTemplate amqpTemplate = ap.getBean("amqpTemplate", RabbitOperations.class);
        for (int i = 0; i < 2; i++) {
            amqpTemplate.convertAndSend("direct-exchange", "queue_one_key", "message " + i);
            //amqpTemplate.convertAndSend("topic-exchange", "tomcat.info.*", "message " + i);
            //amqpTemplate.convertAndSend("topic-exchange", "tomcat.warn.*", "message " + i);
        }
        System.out.println("send is ok");
    }
}
