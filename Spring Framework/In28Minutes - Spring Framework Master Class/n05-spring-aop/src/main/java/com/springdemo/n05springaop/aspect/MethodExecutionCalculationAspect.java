package com.springdemo.n05springaop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Around("com.springdemo.n05springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
  public void after(ProceedingJoinPoint joinPoint) throws Throwable {
    StopWatch watch = new StopWatch(this.getClass().getSimpleName());

    try {
      watch.start(joinPoint.getSignature().getName());
      joinPoint.proceed();
    } finally {
      watch.stop();
      logger.info("After:: Allowed execution of {}", watch.prettyPrint());
      }

  }

}
