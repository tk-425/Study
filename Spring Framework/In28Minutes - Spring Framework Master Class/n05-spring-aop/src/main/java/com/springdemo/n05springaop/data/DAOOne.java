package com.springdemo.n05springaop.data;

import com.springdemo.n05springaop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DAOOne {

  @TrackTime
  public String retrieveSomething() {
    return "DAO One";
  }
}
