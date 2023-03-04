package com.mavendemo;

import org.junit.jupiter.api.Test;

class HelloWorldTest {
  @Test
  void getHello() {
    System.out.println("###### JUnit5 Test:");
    System.out.println("###### " + System.getenv("TEST_HOST"));
    System.out.println("######");
  }
}