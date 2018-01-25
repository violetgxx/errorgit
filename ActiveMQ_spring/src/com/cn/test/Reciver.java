package com.cn.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Reciver {
	
	public static void main(String[] args) {
		
		ApplicationContext application=new ClassPathXmlApplicationContext("classpath:spring.xml");
		
		JmsTemplate jmsTemplate=(JmsTemplate) application.getBean("JmsTemplate");
		
		Map map=(Map) jmsTemplate.receiveAndConvert();
		System.out.println(map.get("mess"));
	}

}
