package com.springdemo.n0webapp.repositories;

import com.springdemo.n0webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
