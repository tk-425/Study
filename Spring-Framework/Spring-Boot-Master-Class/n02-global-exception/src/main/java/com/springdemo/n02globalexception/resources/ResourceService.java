package com.springdemo.n02globalexception.resources;

import com.springdemo.n02globalexception.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

  private ResourceRepository repository;

  @Autowired
  public ResourceService(ResourceRepository repository) {
    this.repository = repository;
  }

  public Customer findById(Long id) {
    return repository.findById(id);
  }

  public List<Customer> findAll() {
    return repository.findAll();
  }

  public Customer findByEmail(String email) {
    return repository.findByEmail(email);
  }
}
