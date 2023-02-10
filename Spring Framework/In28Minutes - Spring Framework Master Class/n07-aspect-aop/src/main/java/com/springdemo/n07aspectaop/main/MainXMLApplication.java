package com.springdemo.n07aspectaop.main;

import com.springdemo.n07aspectaop.main.bo.BusinessObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXMLApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		BusinessObject businessObject = (BusinessObject) applicationContext.getBean("bo");

		try {
			businessObject.validateAge();
			businessObject.validateAge(17);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
