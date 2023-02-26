package com.springdemo.n02globalexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<Object> handleException(CustomerNotFoundException e) {
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setDateTime(LocalDateTime.now());
    exceptionResponse.setMessage("Customer Not Found");

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(PageNotFound.class)
  public ResponseEntity<Object> handleException(PageNotFound e) {
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setDateTime(LocalDateTime.now());
    exceptionResponse.setMessage("Page Not Found");

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InternalServerException.class)
  public ResponseEntity<Object> handleException(InternalServerException e) {
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setDateTime(LocalDateTime.now());
    exceptionResponse.setMessage("Internal Server Error");

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
