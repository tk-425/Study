package com.springdemo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

  @Override
  public List<Customer> getCustomers() {
    return Arrays.asList(
        new Customer(1L, "James Bond"),
        new Customer(2L, "Tiger Woods"),
        new Customer(3L, "Michael Jordan")
    );
  }
}
