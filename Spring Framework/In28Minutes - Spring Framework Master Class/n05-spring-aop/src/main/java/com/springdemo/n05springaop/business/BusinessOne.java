package com.springdemo.n05springaop.business;

import com.springdemo.n05springaop.data.DAOOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessOne {

  private DAOOne daoOne;

  @Autowired
  public BusinessOne(DAOOne daoOne) {
    this.daoOne = daoOne;
  }

  public String calculateSomething() {
    return daoOne.retrieveSomething();
  }

  public String doSomething() {
    return "Business Two Doing Something";
  }
}
