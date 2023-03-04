package com.springdemo.n04profiles;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ProfileApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ProfileApplication.class)
        .profiles("prod", "dev")
        .run(args);
  }

}
