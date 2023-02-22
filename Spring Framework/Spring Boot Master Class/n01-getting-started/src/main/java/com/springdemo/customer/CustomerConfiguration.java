package com.springdemo.customer;

import com.springdemo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

  @Value("${app.useFakeCustomerRepo:true}")
  private Boolean useFakeCustomerRepo;

  @Value("${info.company.name}")
  private String companyName;

  @Bean
  CommandLineRunner commandLineRunner(InfoApp infoApp) {
    return args -> {
      System.out.println("CommandLineRunner - Running");
      System.out.println("Company Name: " + companyName);
      System.out.println(infoApp);
    };
  }

  @Bean
  CustomerRepo customerRepo() {
    return new CustomerFakeRepository();
  }
}
