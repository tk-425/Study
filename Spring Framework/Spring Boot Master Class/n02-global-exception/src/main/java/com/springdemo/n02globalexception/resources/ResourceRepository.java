package com.springdemo.n02globalexception.resources;

import com.springdemo.n02globalexception.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceRepository {

  public Customer findById(Long id) {
    return null;
  }

  public List<Customer> findAll() {
    return null;
  }

  public Customer findByEmail(String email) { return null; }
}
