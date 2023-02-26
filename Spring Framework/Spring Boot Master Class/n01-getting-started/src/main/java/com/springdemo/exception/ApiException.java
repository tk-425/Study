package com.springdemo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {

  @Override
  public String toString() {
    return "ApiException{" +
        "message='" + message + '\'' +
        ", throwable=" + throwable +
        ", httpStatus=" + httpStatus +
        ", zonedDateTime=" + zonedDateTime +
        '}';
  }
}
