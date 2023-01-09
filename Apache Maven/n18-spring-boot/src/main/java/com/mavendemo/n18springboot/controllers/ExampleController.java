package com.mavendemo.n18springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExampleController {

  @RequestMapping("/")
  public Map<String, Object> getIndex() {
    Map<String, Object> result = new HashMap<>();

    result.put("hello", "world");

    return result;
  }
}
