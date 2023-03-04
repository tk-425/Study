package com.springdemo;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Customer {

  @Id
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
  private Integer id;
  private String name;
  private String email;
  private Integer age;

  public Customer() {
  }

  public Customer(Integer id, String name, String email, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Customer customer = (Customer) o;

    return new EqualsBuilder().append(id, customer.id).append(name, customer.name).append(email, customer.email).append(age, customer.age).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id).append(name).append(email).append(age).toHashCode();
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        '}';
  }
}
