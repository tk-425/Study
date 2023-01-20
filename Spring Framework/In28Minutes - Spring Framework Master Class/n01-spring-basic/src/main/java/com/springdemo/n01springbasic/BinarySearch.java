package com.springdemo.n01springbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch {

  // CONSTRUCTOR-BASED DI
  private final SortAlgorithm sortAlgorithm;

  @Autowired
  public BinarySearch(SortAlgorithm sortAlgorithm) {
    this.sortAlgorithm = sortAlgorithm;
  }

/*
//  SETTER-BASED DI

  private SortAlgorithm sortAlgorithm;

  @Autowired
  public void setBinarySearch(SortAlgorithm sortAlgorithm) {
    this.sortAlgorithm = sortAlgorithm;
  }
*/

  public int binarySearch(int[] arr, int n) {
    int[] sortedArray = sortAlgorithm.sort(arr);

    // binary search algorithm goes here...

    // we'll just return 0 for now
    return 0;
  }
}
