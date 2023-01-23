package com.springdemo.n01springbasic.n01_basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
  @Override
  public int[] sort(int[] arr) {
    System.out.println("BubbleSortAlgorithm");
    return new int[0];
  }
}
