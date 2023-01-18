package com.springdemo.n0webapp.repositories;

import com.springdemo.n0webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
