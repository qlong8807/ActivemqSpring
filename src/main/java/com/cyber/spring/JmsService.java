package com.cyber.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("serviceSide")
public class JmsService {
	@Autowired
	@Qualifier("serviceJmsTemplate")
	private JmsTemplate template;

	@Autowired
	private ActiveMQQueue queue;

	// 发送一条简短的消息
	public void simpleSend() {
		template.send(queue, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("您好，abc！");
			}
		});
	}
}