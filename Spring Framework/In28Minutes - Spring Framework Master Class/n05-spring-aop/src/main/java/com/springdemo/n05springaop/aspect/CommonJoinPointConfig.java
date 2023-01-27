package com.springdemo.n05springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
  @Pointcut("execution(* com.springdemo.n05springaop.data.*.*(..))")
  public void dataLayerExecution() {}

  @Pointcut("execution(* com.springdemo.n05springaop.business.*.*(..))")
  public void businessLayerExecution() {}

  @Pointcut("com.springdemo.n05springaop.aspect.CommonJoinPointConfig.dataLayerExecution() && " +
            "com.springdemo.n05springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
  public void allLayerExecution(){}

  @Pointcut("bean(dao*)")
  public void beanStartingWithDao() {}

  @Pointcut("bean(*dao*)")
  public void beanContainingDao() {}

  @Pointcut("within(com.springdemo.n05springaop.data..*)")
  public void allWithinDataLayerExecution() {}

  @Pointcut("@annotation(com.springdemo.n05springaop.aspect.TrackTime)")
  public void trackTimeAnnotation() {}
}
