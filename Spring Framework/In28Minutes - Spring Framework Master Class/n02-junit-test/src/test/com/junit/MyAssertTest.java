package test.com.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {
  private final List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

  @Test
  void todosContainAWSTest() {
    assertTrue(todos.contains("AWS"));
  }

  @Test
  void todosLengthTest() {
    assertEquals(3, todos.size());
  }

  @Test
  void todosContainJavaTest() {
    assertTrue(todos.contains("Java"), "Java not found");
  }

  @Test
  void arraysEqualsTest() {
    assertArrayEquals(new int[] {1, 2, 3}, new int[] {2, 3, 1}, "Different Array");
  }
}