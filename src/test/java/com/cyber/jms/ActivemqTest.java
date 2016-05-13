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

		// ע������ʹ�������ַ�����ȡbean
		JmsService ss = (JmsService) ctx.getBean("serviceSide");
		JmsClient cs = ctx.getBean(JmsClient.class);
		// ����һ����Ϣ��Ȼ�����һ����Ϣ
//		ss.simpleSend();
		cs.simpleReceive();
		cs.simpleReceive();
		ctx.close();
		
	}
}