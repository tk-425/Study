package com.springdemo.library.controller;

import com.springdemo.library.model.Book;
import com.springdemo.library.responsemodels.ShelfCurrentLoansResponse;
import com.springdemo.library.service.BookService;
import com.springdemo.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  private final String sub = "\"sub\"";

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/secure/ischeckedout/byuser")
  public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization") String token,
                                    @RequestParam Long bookId) {
    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    return bookService.checkoutBookByUser(userEmail, bookId);
  }

  @GetMapping("/secure/currentloans/count")
  public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    return bookService.currentLoansCount(userEmail);
  }

  @GetMapping("/secure/currentloans")
  public List<ShelfCurrentLoansResponse> currentLoans(
      @RequestHeader(value = "Authorization") String token) throws Exception {

    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    return bookService.currentLoans(userEmail);
  }

  @PutMapping("/secure/checkout")
  public Book checkoutBook(@RequestHeader(value = "Authorization") String token,
                           @RequestParam Long bookId) throws Exception {
    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    return bookService.checkoutBook(userEmail, bookId);
  }

  @PutMapping("/secure/return")
  public void returnBook(@RequestHeader(value = "Authorization") String token,
                         @RequestParam Long bookId) throws Exception {
    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    bookService.returnBook(userEmail, bookId);
  }

  @PutMapping("/secure/renew/loan")
  public void renewLoan(@RequestHeader(value = "Authorization") String token,
                        @RequestParam Long bookId) throws Exception {
    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    bookService.renewLoan(userEmail, bookId);
  }
}
