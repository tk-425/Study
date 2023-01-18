package com.springdemo.n0webapp.repositories;

import com.springdemo.n0webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
