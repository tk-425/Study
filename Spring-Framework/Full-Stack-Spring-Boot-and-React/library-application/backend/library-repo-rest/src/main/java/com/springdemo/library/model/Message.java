package com.springdemo.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "question")
  private String question;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "admin_email")
  private String adminEmail;

  @Column(name = "response")
  private String response;

  @Column(name = "closed")
  private boolean closed;

  public Message() {}

  public Message(String title, String question) {
    this.title = title;
    this.question = question;
  }
}
