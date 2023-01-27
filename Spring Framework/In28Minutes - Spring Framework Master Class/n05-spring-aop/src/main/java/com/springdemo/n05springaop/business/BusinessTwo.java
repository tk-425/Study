package com.springdemo.n05springaop.business;

import com.springdemo.n05springaop.aspect.TrackTime;
import com.springdemo.n05springaop.data.DAOTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessTwo {

  private DAOTwo daoTwo;

  @Autowired
  public BusinessTwo(DAOTwo daoTwo) {
    this.daoTwo = daoTwo;
  }

  @TrackTime
  public String calculateSomething() {
    return daoTwo.retrieveSomething();
  }

  public String doSomething() {
    return "Business Two Doing Something";
  }

}
