package com.springdemo.customer;

import com.springdemo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  List<Customer> getCustomers() {
    LOGGER.info("getCustomers() was called");
    return customerRepository.findAll();
  }

  Customer getCustomer(Long id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> {
          NotFoundException notFoundException =
              new NotFoundException("Customer ID " + id + " Not Found.");
          LOGGER.error("Error -> getCustomer(Long id)\nid: {}, exception: {}",
              id, notFoundException.toString());
          return notFoundException;
        });
  }
}
