package com.springdemo.n01springbasic.n02_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
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
