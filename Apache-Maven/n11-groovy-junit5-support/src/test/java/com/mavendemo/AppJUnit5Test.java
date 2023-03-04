package com.mavendemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppJUnit5Test {

  @Test
  void getHello() {
    App app = new App();
    assertEquals("Hello World", app.getHello());
  }
}