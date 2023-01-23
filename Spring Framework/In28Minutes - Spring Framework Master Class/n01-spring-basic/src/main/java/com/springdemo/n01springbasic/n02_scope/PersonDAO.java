package com.springdemo.n01springbasic.n02_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO {

  JdbcConnection jdbcConnection;
  @Autowired
  public void setJdbcConnection(JdbcConnection jdbcConnection) {
    this.jdbcConnection = jdbcConnection;
  }

  public JdbcConnection getJdbcConnection() {
    return jdbcConnection;
  }
}
