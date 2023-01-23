package com.springdemo.n01springbasic;

import com.springdemo.n01springbasic.properties.ExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class N05ExternalPropertySpringApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(N05ExternalPropertySpringApplication.class);
  public static void main(String[] args) {
    // Application Context
    try (ClassPathXmlApplicationContext appContext =
                  new ClassPathXmlApplicationContext("applicationContext.xml")) {

      ExternalService service = appContext.getBean(ExternalService.class);

      System.out.println(service.returnServiceURL());
    }
  }
}
