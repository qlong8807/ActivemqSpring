package com.cyber.amp.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
 
public class ConsumerMessageListener implements MessageListener {
 
    public void onMessage(Message message) {
        //��������֪�������߷��͵ľ���һ�����ı���Ϣ�������������ֱ�ӽ���ǿ��ת��
        TextMessage textMsg = (TextMessage) message;
        System.out.println("���յ�һ�����ı���Ϣ��");
        try {
            System.out.println("��Ϣ�����ǣ�" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}