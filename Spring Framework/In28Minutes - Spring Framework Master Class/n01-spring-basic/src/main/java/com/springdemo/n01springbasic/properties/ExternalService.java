package com.springdemo.n01springbasic.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {

  // from app.properties
  @Value("${external.service.url}")
  private String url;

  public String returnServiceURL() {
    return url;
  }
}
