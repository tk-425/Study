package com.mavendemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

  // JUnit4 will run this test method
  // Notice that we do not have to add "test", "tests", or "testCase" in
  // the test method name.
  @Test
  public void getHello() {
    App app = new App();

    assertEquals("Hello World", app.getHello());
  }
}