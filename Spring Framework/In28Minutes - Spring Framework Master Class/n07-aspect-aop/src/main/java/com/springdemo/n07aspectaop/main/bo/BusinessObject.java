package com.springdemo.n07aspectaop.main.bo;

import org.springframework.stereotype.Component;

@Component
public class BusinessObject {

  public void validateAge() {
    System.out.println("\tValidation from BusinessObject");
  }

  public void validateAge(int age) throws Exception {
    if (age < 18) {
      throw new ArithmeticException("Not Valid Age");
    } else {
      System.out.println("\tVote Confirmed");
    }
  }

  public void validateByBirthYear(int birthYear) {
    if (birthYear > 2006) {
      throw new ArithmeticException("Not Valid Age");
    } else {
      System.out.println("\tVote Confirmed");
    }
  }
}
