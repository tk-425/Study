package com.mavendemo.json.springbootjson.controllers;

import com.mavendemo.json.model.ShippingAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
  @RequestMapping("/")
  public ShippingAddress getShippingAddress() {

    return new ShippingAddress();
  }
}
