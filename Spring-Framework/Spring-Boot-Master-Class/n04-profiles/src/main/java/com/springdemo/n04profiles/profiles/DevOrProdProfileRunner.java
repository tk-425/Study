package com.springdemo.n04profiles.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = {"dev", "prod"})
public class DevOrProdProfileRunner implements CommandLineRunner {

  @Value("${message}")
  private String message;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("** Message: " + message);
  }
}
