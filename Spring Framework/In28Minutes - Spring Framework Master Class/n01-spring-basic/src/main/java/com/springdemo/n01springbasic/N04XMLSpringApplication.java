package com.springdemo.n01springbasic;

import com.springdemo.n01springbasic.n03_xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class N04XMLSpringApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(N04XMLSpringApplication.class);
  public static void main(String[] args) {
    // Application Context
    try (ClassPathXmlApplicationContext appContext =
                  new ClassPathXmlApplicationContext("applicationContext.xml")) {

      LOGGER.info("Beans Loaded -> {}", (Object) appContext.getBeanDefinitionNames());

      XmlPersonDAO xmlPersonDAO = appContext.getBean(XmlPersonDAO.class);

      LOGGER.info("{} {}", xmlPersonDAO, xmlPersonDAO.getXmlJdbcConnection());
    }
  }
}
