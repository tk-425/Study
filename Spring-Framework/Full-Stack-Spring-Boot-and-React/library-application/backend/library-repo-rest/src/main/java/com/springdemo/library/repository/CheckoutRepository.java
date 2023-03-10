package com.springdemo.library.repository;

import com.springdemo.library.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

  Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

  List<Checkout> findBooksByUserEmail(String userEmail);

  @Modifying
  @Query("DELETE FROM Checkout c WHERE c.bookId IN :book_id")
  void deleteByBookId(@Param("book_id") Long bookId);
}
