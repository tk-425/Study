package com.springdemo.n07aspectaop.main.bo;

import org.springframework.stereotype.Component;

@Component
public class BusinessObject {

  public void validate() {
    System.out.println("\tValidation from BusinessObject");
  }

  public void validate(int age) throws Exception {
    if (age < 18) {
      throw new ArithmeticException("Not Valid Age");
    } else {
      System.out.println("\tVote Confirmed");
    }
  }
}
