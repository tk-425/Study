package com.springdemo.n05springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DAOTwo {
  public String retrieveSomething() {
    return "DAO Two";
  }
}
