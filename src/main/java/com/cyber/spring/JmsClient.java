package com.cyber.spring;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
 
@Component("clientSide")
public class JmsClient {
    @Autowired
    @Qualifier("customJmsTemplate")
    private JmsTemplate template;
    @Autowired
    private ActiveMQQueue queue;
 
//接收并输出消息
    public void simpleReceive() throws JMSException
    {
       TextMessage tm = (TextMessage) template.receive(queue);
       System.out.println(tm.getText());
    }
   
}