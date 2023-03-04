package com.springdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  @Modifying
  @Transactional
  @Query("UPDATE Customer c SET c.name = :name, c.email = :email, c.age = :age WHERE c.id = :id")
  void updateById(@Param("name") String name, @Param("email") String email,
                  @Param("age") Integer age, @Param("id") Integer id);
}
