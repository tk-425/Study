package com.springdemo.n01springbasic;

import com.springdemo.componentscan.ComponentDAO;
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
@ComponentScan(basePackages = {"com.springdemo.componentscan","com.springdemo.n01springbasic"})
public class N03ComponentScanSpringApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(N03ComponentScanSpringApplication.class);
  public static void main(String[] args) {
    // Application Context
    ApplicationContext appContext =
            new AnnotationConfigApplicationContext(N03ComponentScanSpringApplication.class);

    ComponentDAO componentDAO =
            appContext.getBean(ComponentDAO.class);

    LOGGER.info("componentDAO {}", componentDAO);
    LOGGER.info("componentDAO {}", componentDAO.getComponentJdbcConnection());

    PersonDAO personDAO = appContext.getBean(PersonDAO.class);

    LOGGER.info("personDAO {}", personDAO);
    LOGGER.info("personDAO {}", personDAO.getJdbcConnection());
  }
}
