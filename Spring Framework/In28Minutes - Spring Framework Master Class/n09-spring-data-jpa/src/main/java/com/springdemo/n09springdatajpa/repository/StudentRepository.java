package com.springdemo.n09springdatajpa.repository;

import com.springdemo.n09springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  public List<Student> findByFirstName(String firstName);

  public Streamable<Student> findByFirstNameContaining(String name);

  public Streamable<Student> findByLastNameContaining(String name);

  public Streamable<Student> findByLastNameNotNull();

  public Streamable<Student> findByGuardianName(String name);

  // JPQL
  @Query("select s from Student s where s.emailId = ?1")
  public Student getStudentByEmailAddress(String emailId);

  @Query("select s.firstName from Student s where s.emailId = :emailId")
  public String getStudentFirstNameByEmailAddress(@Param("emailId") String email);

  // Native Query
  @Query(
          value = "select * from tbl_student s where s.email_address = ?1",
          nativeQuery = true
  )
  Student getStudentsByEmailAddressNative(String emailId);

  @Query(
          value = "select * from tbl_student s where s.email_address = :email",
          nativeQuery = true
  )
  Student getStudentsByEmailAddressNativeNamed(@Param("email") String emailId);

  // Modifying
  @Modifying
  @Transactional
  @Query("update Student s set s.firstName = ?1 where s.emailId = ?2")
  int updateStudentNameByEmailId(String firstName, String emailId);

  @Modifying
  @Transactional
  @Query(
          value = "update tbl_student set first_name = ?1 where email_address = ?2",
          nativeQuery = true
  )
  int updateStudentNameByEmailIdNative(String firstName, String emailId);


}
