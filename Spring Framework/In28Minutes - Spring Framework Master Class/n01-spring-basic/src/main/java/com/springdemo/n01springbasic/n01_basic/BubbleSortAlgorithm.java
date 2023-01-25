package com.springdemo.n01springbasic.n01_basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
  @Override
  public int[] sort(int[] arr) {
    System.out.println("BubbleSortAlgorithm");

    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap arr[j + 1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    return arr;
  }
}
