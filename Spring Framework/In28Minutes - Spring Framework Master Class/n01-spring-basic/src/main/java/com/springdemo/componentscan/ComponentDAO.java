package com.springdemo.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentDAO {

  ComponentJdbcConnection componentJdbcConnection;
  @Autowired
  public void setComponentJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
    this.componentJdbcConnection = componentJdbcConnection;
  }

  public ComponentJdbcConnection getComponentJdbcConnection() {
    return componentJdbcConnection;
  }
}