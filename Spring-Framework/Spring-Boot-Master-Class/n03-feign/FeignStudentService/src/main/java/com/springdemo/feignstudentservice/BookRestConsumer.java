package com.springdemo.feignstudentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookRestConsumer {

  @GetMapping("/book/data")
  String getBookData();

  @GetMapping("/book/all")
  List<Book> getAllBooks();

  @GetMapping("/book/{id}")
  Book getBookById(@PathVariable("id") Integer id);

  @GetMapping("/book/entity")
  ResponseEntity<String> getEntityData();
}
