package com.springdemo.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {

  @Id
  @TableGenerator(
          name = "table_generator",
          table = "member_id",
          pkColumnValue = "MEMBER_SEQ",
          allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
  @Column(name = "ID")
  private Long id;

  @Column(
          name = "NAME",
          nullable = false,
          length = 10
  )
  private String userName;

  @ManyToOne
  @JoinColumn(
          name = "TEAM_ID",
          insertable = false,
          updatable = false
  )
  private Team team;

  @OneToOne
  @JoinColumn(name = "LOCKER_ID")
  private Locker locker;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "MEMBER_PRODUCT",
          joinColumns = @JoinColumn(name = "MEMBER_ID"),
          inverseJoinColumns = @JoinColumn(name = "PROUDUCT_ID")
  )
  private List<Product> products = new ArrayList<>();

  private Integer age;

  /*
  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedData;

  @Lob
  private String description;

  @Transient
  private String temp;

  public enum RoleType {
    ADMIN, USER
  }
  */


  /* --- Getters & Setters --- */
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    if (this.team != null) {
      this.team.getMembers().remove(this);
    }

    this.team = team;
    team.getMembers().add(this);
  }

  public Locker getLocker() {
    return locker;
  }

  public void setLocker(Locker locker) {
    this.locker = locker;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void addProduct(Product product) {
    products.add(product);
    product.getMembers().add(this);
  }

  /* ---- toString() --- */
  @Override
  public String toString() {
    return "Member{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", team=" + team +
            ", locker=" + locker +
            ", products=" + products +
            ", age=" + age +
            '}';
  }
}
