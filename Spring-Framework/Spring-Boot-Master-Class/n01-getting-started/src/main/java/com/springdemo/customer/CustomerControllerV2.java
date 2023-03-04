package com.springdemo.customer;

import com.springdemo.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {

  private final CustomerService customerService;

  @Autowired
  public CustomerControllerV2(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  List<Customer> getCustomers() {
    System.out.println("GET REQUEST FOR ALL CUSTOMERS");
    return customerService.getCustomers();
  }

  @GetMapping(path = "{customerId}")
  Customer getCustomer(@PathVariable("customerId") Long id) {
    System.out.println("GET REQUEST FOR CUSTOMER WITH ID " + id);
    return customerService.getCustomer(id);
  }

  // method for throwing custom exceptions
  @GetMapping(path = "{customerId}/exception")
  Customer getCustomerException(@PathVariable("customerId") Long id) {
    System.out.println("THROWING CUSTOM EXCEPTION...");
    throw new ApiRequestException(
        "ApiRequestException for customer " + id, null, false, false
    );
  }

  @PostMapping
  void createNewCustomer(@Valid @RequestBody Customer customer) {
    System.out.print("POST REQUEST: ");
    printCustomerInfo(customer);
  }

  @PutMapping
  void updateCustomer(@Valid @RequestBody Customer customer) {
    System.out.print("PUT REQUEST");
    printCustomerInfo(customer);
  }

  @DeleteMapping(path = "{customerId}")
  void deleteCustomer(@PathVariable("customerId") Long id) {
    System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
  }

  private void printCustomerInfo(Customer customer) {
    System.out.println("{ Name: " + customer.getName() +
        ", PW: " + customer.getPassword() +
        ", ID: " + customer.getId() +
        ", EMAIL: " + customer.getEmail() + " }");
  }
}
