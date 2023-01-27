package com.springdemo.n06classicalapproachaop.main;

import com.springdemo.n06classicalapproachaop.main.to.BusinessObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class N06ClassicalApproachAopApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

		BusinessObject bo = applicationContext.getBean("proxy", BusinessObject.class);

		try {
			bo.validate();
			bo.validate(17);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
