package com.springdemo.springdatajpa.repository;

import com.springdemo.springdatajpa.entity.StudentIdCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {
}
