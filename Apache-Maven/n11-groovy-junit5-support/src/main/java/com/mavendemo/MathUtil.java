package com.mavendemo;

public class MathUtil {
  public static int sumBiggestPair (int a, int b, int c) {
    int op1 = a;
    int op2 = b;

    if (c > a) {
      op1 = c;
    } else if (c > b) {
      op2 = c;
    }

    return op1 + op2;
  }
}
