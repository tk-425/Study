package com.springdemo.n07aspectaop.main;

import com.springdemo.n07aspectaop.main.bo.BusinessObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainSpringApplication implements CommandLineRunner {

  private BusinessObject business;

  @Autowired
  public MainSpringApplication(BusinessObject business) {
    this.business = business;
  }

  public static void main(String[] args) {
    SpringApplication.run(MainSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    try {
      business.validate();
      business.validate(17);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
