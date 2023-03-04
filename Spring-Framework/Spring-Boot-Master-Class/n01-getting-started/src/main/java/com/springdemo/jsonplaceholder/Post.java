package com.springdemo.jsonplaceholder;

public class Post {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;

  public Post(Integer userId, Integer id, String title, String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public Integer getUserId() {
    return userId;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  @Override
  public String toString() {
    return "Post{" +
        "userId=" + userId +
        ", id=" + id +
        ", title='" + title + '\'' +
        ", body='" + body + '\'' +
        '}';
  }
}
