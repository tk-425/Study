package com.springdemo.n01springbasic;

import com.springdemo.n01springbasic.n02_scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan
public class N02ScopeSpringApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(N02ScopeSpringApplication.class);
  public static void main(String[] args) {
    // Application Context
    AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext(N02ScopeSpringApplication.class);

    PersonDAO personDAO1 =
            appContext.getBean(PersonDAO.class);

    PersonDAO personDAO2 =
            appContext.getBean(PersonDAO.class);

    LOGGER.info("personDAO1 {}", personDAO1);
    LOGGER.info("personDAO1 {}", personDAO1.getJdbcConnection());

    LOGGER.info("personDAO2 {}", personDAO2);
    LOGGER.info("personDAO2 {}", personDAO2.getJdbcConnection());

    appContext.close();
  }
}
