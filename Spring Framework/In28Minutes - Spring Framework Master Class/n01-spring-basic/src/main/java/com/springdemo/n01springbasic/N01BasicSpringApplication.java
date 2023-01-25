package com.springdemo.n01springbasic;

import com.springdemo.n01springbasic.n01_basic.BinarySearch;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan
public class N01BasicSpringApplication {

	public static void main(String[] args) {
/*
		ApplicationContext appContext =
						SpringApplication.run(N01BasicSpringApplication.class, args);

		BinarySearch binarySearch1 =
						appContext.getBean(BinarySearch.class);

		BinarySearch binarySearch2 =
						appContext.getBean(BinarySearch.class);

		int result1 = binarySearch1.binarySearch(new int[] {12, 2, 5}, 5);
		System.out.println("Result 1: " + result1);

		int result2 = binarySearch2.binarySearch(new int[] {12, 2, 5}, 5);
		System.out.println("Result 2: " + result2);

		System.out.println("BinarySearch 1: " + binarySearch1);
		System.out.println("BinarySearch 2: " + binarySearch2);
*/

		/* without Spring Boot Starter Package */
		try (AnnotationConfigApplicationContext appContext =
						new AnnotationConfigApplicationContext(N01BasicSpringApplication.class)) {

			BinarySearch binarySearch1 =
							appContext.getBean(BinarySearch.class);

			BinarySearch binarySearch2 =
							appContext.getBean(BinarySearch.class);

			int result1 = binarySearch1.binarySearch(new int[]{12, 2, 5}, 5);
			System.out.println("Result 1: " + result1);

			int result2 = binarySearch2.binarySearch(new int[]{12, 2, 5}, 5);
			System.out.println("Result 2: " + result2);

			System.out.println("BinarySearch 1: " + binarySearch1);
			System.out.println("BinarySearch 2: " + binarySearch2);
		}
	}

}
