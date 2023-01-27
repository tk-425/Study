package com.springdemo.n06classicalapproachaop.main.aspect;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvisor implements ThrowsAdvice {

  public void afterThrowing(Exception e) {
    System.out.println("[**Exception**] exception occurred");
  }
}
