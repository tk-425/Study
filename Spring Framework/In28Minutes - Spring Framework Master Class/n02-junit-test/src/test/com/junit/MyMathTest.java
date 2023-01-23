package test.com.junit;

import main.com.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

  private final MyMath math = new MyMath();

  @Test
  void test1() {
    assertEquals(6, math.sum(new int[]{1, 2, 3}));
  }

  @Test
  void test2() {
    assertEquals(0, math.sum(new int[]{}));
  }
}