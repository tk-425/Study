package com.springdemo.n06classicalapproachaop.main.aspect;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvisor implements AfterReturningAdvice {

  @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    System.out.println("[After] logging after call of method: " + method.getName());
  }
}
