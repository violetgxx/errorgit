package com.cn.test;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Provider {
	
	public static void main(String[] args) {
		ApplicationContext application=new ClassPathXmlApplicationContext("classpath:spring.xml");
		
		JmsTemplate jmsTemplate=(JmsTemplate) application.getBean("JmsTemplate");
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				String msg="helloworld";
				MapMessage map=session.createMapMessage();
				map.setString("mess", msg);
				return map;
			}
		});
	}

}
