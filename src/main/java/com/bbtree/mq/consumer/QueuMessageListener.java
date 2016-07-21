package com.bbtree.mq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by Administrator on 2016/7/20.
 */
public class QueuMessageListener implements MessageListener {

    public void onMessage(Message message) {
        String receiveMsg = null;
        try {
            receiveMsg = new String(message.getBody(), "utf-8");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("queu - receiver -" + receiveMsg + "-" + message.getMessageProperties().getMessageId());
    }
}
