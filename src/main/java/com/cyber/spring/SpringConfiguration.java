package com.cyber.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.xbean.BrokerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class SpringConfiguration {

	// ע��һ�����ӹ�����������ӹ���bean���ڱ����ж���ġ�
	@Autowired
	private ActiveMQConnectionFactory connectionFactory;

	// ����activemq�����һ��ʵ����������Ҫ��Ϊ������һ��Ƕ��ʽ��jms����vm��
	@Bean(name = "brokerFactory")
	public BrokerFactoryBean brokerFactoryBean() {
		// ��������ʱ��ָ������������������ĵ���������ǰ�������õ��Ǹ��ĵ�
		BrokerFactoryBean bfb = new BrokerFactoryBean(new ClassPathResource(
				"activemq.xml"));
		// ���ó�������ʱ��������
		bfb.setStart(true);
		return bfb;
	}

	// ����һ�����ӹ��������ڳ������ӵ�activemq����
	@Bean(name = "connectionFactory")
	public ActiveMQConnectionFactory connectionFactory() {
		// ָ�����ӵ�����vm���Ǹ�����ע�����vm����brokerFactory���������Ǹ�����
		ActiveMQConnectionFactory amqf = new ActiveMQConnectionFactory(
				"vm://localhost");
		return amqf;
	}

	// ����һ����Ϣ����
	@Bean(name = "queue")
	public ActiveMQQueue queue() {
		ActiveMQQueue q = new ActiveMQQueue();
		q.setPhysicalName("activemqTest");
		return q;
	}

	// ��������˵�jmsTemplate��һ������·���˺Ϳͻ��˵�jmsTemplate����������ͬ����Ϊ��Ч�����أ����ǽ���ֿ����ã������Ӧ����������������������ʹ��singleConnectionFactory����
	@Bean(name = "serviceJmsTemplate")
	public JmsTemplate jmsTemplate() {
		JmsTemplate jt = new JmsTemplate();
		SingleConnectionFactory scf = new SingleConnectionFactory();
		scf.setTargetConnectionFactory(connectionFactory);
		jt.setConnectionFactory(scf);
		return jt;
	}

	// �ͻ��˵�jmsTemplate
	@Bean(name = "customJmsTemplate")
	public JmsTemplate jmsTemplateCustom() {
		JmsTemplate jt = new JmsTemplate();
		jt.setConnectionFactory(connectionFactory);
		return jt;
	}
}