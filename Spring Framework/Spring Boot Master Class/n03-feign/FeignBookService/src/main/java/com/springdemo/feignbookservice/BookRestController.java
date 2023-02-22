package com.springdemo.feignbookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// spring.application.name=BOOK-SERVICE
@RestController
@RequestMapping("/book")
public class BookRestController {

  private final Environment environment;

  @Autowired
  public BookRestController(Environment environment) {
    this.environment = environment;
  }


  @GetMapping("/data")
  public String getBookDate() {
    return "Data of BOOK-SERVICE, Running on port: " + environment.getProperty("local.server.port");
  }

  @GetMapping("/all")
  public List<Book> getAll() {
    return List.of(
        new Book(501, "Head First Java", 439.75),
        new Book(502, "Spring in Action", 340.99),
        new Book(503, "Hibernate in Action", 355.95)
    );
  }

  @GetMapping("/{id}")
  public Book getBookById(@PathVariable("id") Integer id) {
    return new Book(id, "Head First Java", 500.75);
  }

  @GetMapping("/entity")
  public ResponseEntity<String> getEntityDate() {
    return new ResponseEntity<>(
        "Hello from BookRestController",
        HttpStatus.OK
    );
  }
}
