package com.springdemo.n04profiles.profiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "dev")
public class DevProfileRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("** In Development...");
  }
}
