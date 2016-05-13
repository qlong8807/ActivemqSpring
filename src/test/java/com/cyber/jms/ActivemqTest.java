package com.cyber.jms;

import javax.jms.JMSException;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cyber.spring.JmsClient;
import com.cyber.spring.JmsService;

public class ActivemqTest {
	@Test
	public void startTest() throws JMSException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cyber");
		ctx.refresh();

		// 注意下面使用了两种方法获取bean
		JmsService ss = (JmsService) ctx.getBean("serviceSide");
		JmsClient cs = ctx.getBean(JmsClient.class);
		// 发送一条消息，然后接收一条消息
//		ss.simpleSend();
		cs.simpleReceive();
		cs.simpleReceive();
		ctx.close();
		
	}
}