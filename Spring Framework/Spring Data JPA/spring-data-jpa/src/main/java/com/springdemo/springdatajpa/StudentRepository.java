package com.springdemo.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);

  @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age = ?2")
  List<Student> findStudentByFirstNameEqualsAndAgeEquals(String firstName, int age);

  @Query("SELECT  s FROM Student s WHERE s.firstName = ?1 AND  s.age > ?2")
  List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThan(String firstName, int age);

}
