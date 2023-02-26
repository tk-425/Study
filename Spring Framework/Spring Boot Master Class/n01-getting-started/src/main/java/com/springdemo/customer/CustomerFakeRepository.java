package com.springdemo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

  private final List<Customer> customers = Arrays.asList(
      new Customer(1L, "James Bond", "password1", "email@mail.com"),
      new Customer(2L, "Tiger Woods", "password2", "email@mail.com"),
      new Customer(3L, "Michael Jordan", "password3", "email@mail.com")
  );

  @Override
  public List<Customer> getCustomers() {
    return customers;
  }
}
