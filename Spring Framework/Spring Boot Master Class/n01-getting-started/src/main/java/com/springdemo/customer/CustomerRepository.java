package com.springdemo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class CustomerRepository implements CustomerRepo {

  @Override
  public List<Customer> getCustomers() {
    // TODO: connect to real db
    return Collections.emptyList();
  }
}
