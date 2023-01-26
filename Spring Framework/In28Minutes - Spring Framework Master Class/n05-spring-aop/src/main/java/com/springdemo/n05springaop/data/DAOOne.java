package com.springdemo.n05springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DAOOne {
  public String retrieveSomething() {
    return "DAO One";
  }
}
