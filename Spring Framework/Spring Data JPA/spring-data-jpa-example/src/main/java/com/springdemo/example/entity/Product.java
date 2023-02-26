package com.springdemo.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "PRODUCT")
public class Product {

  @Id
  @SequenceGenerator(
          name = "product_sequence",
          sequenceName = "product_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = SEQUENCE,
          generator = "product_sequence"
  )
  @Column(
          name = "PRODUCT_ID",
          nullable = false
  )
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "products")
  private List<Member> members = new ArrayList<>();


  /* --- Getters & Setters --- */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  /* ---- toString() --- */
  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}