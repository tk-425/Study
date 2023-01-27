package com.springdemo.n06classicalapproachaop.main.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BothAdvisor implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("[Interceptor] Before Method");
    invocation.proceed();
    System.out.println("[Interceptor] After Method");
    return null;
  }
}
