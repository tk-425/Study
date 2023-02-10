package com.springdemo.n07aspectaop.main.bo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CentralAopAspect {

  /*
    regex, classname starts with BusinessObject & method name should be valid*
    .. == optional arguments
   */
  @Pointcut("execution(* BusinessObject.valid*(..))")
  public void v() {}

  @Before("v()")
  public void beforeMethod(JoinPoint joinPoint) {
    System.out.println("[Before] " + joinPoint.getSignature());
  }

  @After("v()")
  public void afterMethod(JoinPoint joinPoint) {
    System.out.println("[After] " + joinPoint.getSignature());
  }

  @Around("v()")
  public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("[Around-Before]");
    Object obj = joinPoint.proceed();
    System.out.println("[Around-After]");

    return obj;
  }

  @AfterThrowing(pointcut = "execution(* BusinessObject.*(..))", throwing = "error")
  public void afterThrowingExceptionMethod(JoinPoint joinPoint, Throwable error) {
    System.out.println("[AfterThrowing]");
    System.out.println("\tMethod Signature: " + joinPoint.getSignature());
    System.out.println("\tException: " + error);
    System.out.println("[AfterThrowing] Completed");
  }
}
