package com.springdemo.n06classicalapproachaop.main.to;

public class BusinessObject {

  public void validate() {
    System.out.println("Validation from BO");
  }

  public void validate(int age) throws Exception {
    if (age < 18) {
      throw new ArithmeticException("Not Valid Age");
    } else {
      System.out.println("Vote Confirmed");
    }
  }
}
