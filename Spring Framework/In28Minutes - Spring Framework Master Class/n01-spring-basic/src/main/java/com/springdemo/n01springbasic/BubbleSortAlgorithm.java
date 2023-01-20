package com.springdemo.n01springbasic;

import org.springframework.stereotype.Component;

@Component("sortAlgorithm")
public class BubbleSortAlgorithm implements SortAlgorithm {
  @Override
  public int[] sort(int[] arr) {
    return new int[0];
  }
}
