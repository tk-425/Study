package com.mavendemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppJUnit4Test {

  @Test
  public void getHello() {
    App app = new App();
    assertEquals("Hello World", app.getHello());
  }
}