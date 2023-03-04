package com.springdemo.mappingquestion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Book {

  @Id
  @GeneratedValue
  private Long id;

  private String isbn;
  private String title;

  @ManyToOne
  private BookStore bookStore;
}
