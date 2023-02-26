package com.springdemo.springdatajpa.repository;

import com.springdemo.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);

  @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age = ?2")
  List<Student> findStudentByFirstNameEqualsAndAgeEquals(String firstName, int age);

  @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND  s.age > :age")
  List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThan(
          @Param("firstName") String firstName,
          @Param("age") int age
  );

  @Query(
          value = "SELECT * FROM student WHERE first_name = ?1 AND  age > ?2",
          nativeQuery = true
  )
  List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanNative(String firstName, int age);

  @Transactional
  @Modifying
  @Query("DELETE FROM Student s WHERE s.id = :id")
  int deleteStudentById(@Param("id") Long id);

  @Query("SELECT s from Student s JOIN FETCH s.books WHERE s.id = :id")
  Student findByIdAndJoinBookColumn(@Param("id") Long id);

}
