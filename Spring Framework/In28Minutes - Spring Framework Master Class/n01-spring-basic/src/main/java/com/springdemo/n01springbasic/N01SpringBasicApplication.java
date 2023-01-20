package com.springdemo.n01springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class N01SpringBasicApplication {

	public static void main(String[] args) {
		// Application Context
		ApplicationContext appContext =
						SpringApplication.run(N01SpringBasicApplication.class, args);

		BinarySearch binarySearch =
						appContext.getBean(BinarySearch.class);

		int result = binarySearch.binarySearch(new int[] {12, 2, 5}, 5);

		// display 0 for now
		System.out.println("Result: " + result);
	}

}
