package com.mavendemo;

public class AppTest {

  // POJO test must start with "test" in front of the method name
  // This is a POJO test.
  // Surefire will pick up anything that begins or ends with "test"
  // or ends with "tests" or "testCase" which is a default behavior
  // of Maven Surefire and Surefire will apply to all tests.
  public void testGetHello() {
    App app = new App();
    assert("Hello World".equals(app.getHello()));
  }
}