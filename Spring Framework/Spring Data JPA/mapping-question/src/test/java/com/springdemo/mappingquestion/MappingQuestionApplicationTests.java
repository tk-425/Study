package com.springdemo.mappingquestion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MappingQuestionApplicationTests {

  @Autowired
  BookStoreRepository bookStoreRepository;

  @Autowired
  BookRepository bookRepository;

  @Test
  public void contextLoad() {
    BookStore bookStore = new BookStore();
    bookStore.setName("JPA Guide");
    bookStoreRepository.save(bookStore);

    Book book = new Book();
    book.setTitle("Let's study JPA");

    bookStore.add(book);

    bookRepository.save(book);
  }

}
