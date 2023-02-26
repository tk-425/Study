package com.springdemo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

  @Id
  private Long id;

  @NotBlank(message = "The name field must not be left blank.")
  private String name;

  @NotBlank(message = "The password field must not be left blank.")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotBlank(message = "The email field must not be left blank.")
  @Email
  private String email;

  public Customer() {}

  public Customer(Long id, String name, String password, String email) {
    System.out.println("Creating Customer...");
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
  }

  @JsonProperty("customer_id")
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @JsonIgnore
  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
