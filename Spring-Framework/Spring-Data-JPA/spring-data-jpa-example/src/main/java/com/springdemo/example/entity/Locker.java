package com.springdemo.example.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "LOCKER")
public class Locker {

  @Id
  @SequenceGenerator(
          name = "locker_sequence",
          sequenceName = "locker_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = SEQUENCE,
          generator = "locker_sequence"
  )
  @Column(
          name = "LOCKER_ID",
          nullable = false
  )
  private Long id;

  private String name;

  @OneToOne(mappedBy = "locker")
  private Member member;


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

  /* ---- toString() --- */
  @Override
  public String toString() {
    return "Locker{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", member=" + member +
            '}';
  }
}