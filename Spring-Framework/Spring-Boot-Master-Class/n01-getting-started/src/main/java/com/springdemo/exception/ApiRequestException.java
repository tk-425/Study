package com.springdemo.exception;

public class ApiRequestException extends RuntimeException {

  public ApiRequestException(String message) {
    super(message);
  }

  public ApiRequestException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApiRequestException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
