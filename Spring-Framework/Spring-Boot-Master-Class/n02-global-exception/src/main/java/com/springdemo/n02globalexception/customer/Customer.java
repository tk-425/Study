package com.springdemo.n02globalexception.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
  private Long id;
  private String name;
  private String email;

  public Customer() {}

  public Customer(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  @JsonProperty("customer_id")
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
