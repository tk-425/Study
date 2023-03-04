package com.springdemo.feignstudentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//spring.application.name=STUDENT-SERVICE
@RestController
@RequestMapping("/student")
public class StudentRestController {

  private final BookRestConsumer consumer;

  @Autowired
  public StudentRestController(BookRestConsumer consumer) {
    this.consumer = consumer;
  }


  @GetMapping("/data")
  public String getStudentInfo() {
    // prints as a proxy class
    System.out.println(consumer.getClass().getName());
    return "Accessing from STUDENT-SERVICE ⤵⤵⤵ \n\t" + consumer.getBookData();
  }

  @GetMapping("/allBooks")
  public String getBooksInfo() {
    return "Accessing from STUDENT-SERVICE ⤵⤵⤵ \n\t" + consumer.getAllBooks();
  }

  @GetMapping("/getOneBook/{id}")
  public String getOneBookForStudent(@PathVariable("id") Integer id) {
    return "Accessing from STUDENT-SERVICE ⤵⤵⤵ \n\t" + consumer.getBookById(id);
  }

  @GetMapping("/entityData")
  public String printEntityData() {
    ResponseEntity<String> response = consumer.getEntityData();
    return "Accessing from STUDENT-SERVICE ⤵⤵⤵ \n\t" + response.getBody() +
        "\n\tStatus: " + response.getStatusCode();
  }
}
