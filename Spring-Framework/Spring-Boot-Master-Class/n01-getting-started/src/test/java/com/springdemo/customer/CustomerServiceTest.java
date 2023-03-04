package com.springdemo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {

  @Autowired
  private CustomerRepository customerRepository;

  private CustomerService underTest;

  @BeforeEach
  void setUp() {
    underTest = new CustomerService(customerRepository);
  }

  @AfterEach
  void tearDown() {
    customerRepository.deleteAll();
  }

  @Test
  void getCustomers() {
    // given
    Customer tim = new Customer(1L, "tim", "password", "tim@mail.com");
    Customer jake = new Customer(2L, "jake", "password", "jake@mail.com");
    customerRepository.saveAll(List.of(tim, jake));

    // when
    List<Customer> customers = underTest.getCustomers();

    // then
    assertEquals(2, customers.size());
  }

  @Test
  void getCustomer() {
    // given
    Customer tim = new Customer(1L, "tim", "password", "tim@mail.com");
    customerRepository.save(tim);

    // when
    Customer actualCustomer = underTest.getCustomer(1L);

    // then
    assertEquals(1L, actualCustomer.getId());
    assertEquals("tim", actualCustomer.getName());
    assertEquals("password", actualCustomer.getPassword());
    assertEquals("tim@mail.com", actualCustomer.getEmail());
  }
}