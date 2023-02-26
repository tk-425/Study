package com.springdemo.n02globalexception.resources;

import com.springdemo.n02globalexception.customer.Customer;
import com.springdemo.n02globalexception.exception.CustomerNotFoundException;
import com.springdemo.n02globalexception.exception.InternalServerException;
import com.springdemo.n02globalexception.exception.PageNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

  private final ResourceService resourceService;

  @Autowired
  public ResourceController(ResourceService resourceService) {
    this.resourceService = resourceService;
  }

  // BAD_REQUEST
  @GetMapping("/getCustomerById/{id}")
  public Customer getCustomerById(@PathVariable("id") Long id) {
    Customer customer = resourceService.findById(id);

    if (customer == null) throw new CustomerNotFoundException();

    return customer;
  }

  // NOT_FOUND
  @GetMapping("/getCustomers")
  public List<Customer> getCustomers() {
    List<Customer> customers = resourceService.findAll();

    if (customers == null) throw new PageNotFound();

    return customers;
  }

  // INTERNAL_SERVER_ERROR
  @GetMapping("/getCustomerByEmail/{email}")
  public Customer getCustomerByEmail(@PathVariable("email") String email) {
    Customer customer = resourceService.findByEmail(email);

    if (customer == null) throw new InternalServerException();

    return customer;
  }
}
