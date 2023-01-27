package com.springdemo.n05springaop;

import com.springdemo.n05springaop.business.BusinessOne;
import com.springdemo.n05springaop.business.BusinessTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class N05SpringAopApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private BusinessOne businessOne;
	private BusinessTwo businessTwo;

	@Autowired
	public N05SpringAopApplication(BusinessOne businessOne, BusinessTwo businessTwo) {
		this.businessOne = businessOne;
		this.businessTwo = businessTwo;
	}

	public static void main(String[] args) {
		SpringApplication.run(N05SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(businessOne.calculateSomething());
		logger.info(businessOne.doSomething());
		logger.info(businessTwo.calculateSomething());
	}
}
