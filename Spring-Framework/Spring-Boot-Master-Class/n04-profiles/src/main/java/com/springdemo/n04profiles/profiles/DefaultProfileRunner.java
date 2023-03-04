package com.springdemo.n04profiles.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DefaultProfileRunner implements CommandLineRunner {

  private final Environment environment;

  @Autowired
  public DefaultProfileRunner(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("** Active Profiles: " +
        Arrays.toString(environment.getActiveProfiles()));
  }
}
