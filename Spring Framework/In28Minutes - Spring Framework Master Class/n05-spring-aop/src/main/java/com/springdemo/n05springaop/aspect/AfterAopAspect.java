package com.springdemo.n05springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @After("com.springdemo.n05springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
  public void after(JoinPoint joinPoint) {
    logger.info("After:: Allowed execution of {}", joinPoint);
  }

  @AfterReturning(value = "com.springdemo.n05springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    logger.info("AfterReturning:: {} returned with value --> {}", joinPoint, result);
  }

  // Intercepting Exception
  @AfterThrowing(value = "com.springdemo.n05springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", throwing = "exception")
  public void afterThrowing(JoinPoint joinPoint, Exception exception) throws Throwable {
    logger.info("AfterThrowing:: {} returned with exception --> {}", joinPoint, exception);
  }
}
