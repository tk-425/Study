package com.springdemo.n01springbasic.n01_basic;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearch {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private SortAlgorithm sortAlgorithm;

  @Autowired
  @Qualifier("bubble")
  public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
    this.sortAlgorithm = sortAlgorithm;
  }

  public int binarySearch(int[] arr, int n) {
    if (arr.length == 0) {
      return Integer.MIN_VALUE;
    }

    int[] sortedArray = sortAlgorithm.sort(arr);

    int start = 0, end = sortedArray.length - 1;

    while (end - start > 1) {
      int mid = (start + end) / 2;
      if (sortedArray[mid] < n) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    if (sortedArray[start] == n) {
      return start;
    } else if (sortedArray[end] == n) {
      return end;
    }

    System.out.println("Not Found - Returning Integer.MIN_VALUE");

    return Integer.MIN_VALUE;
  }

  @PostConstruct
  public void postConstruct() {
    logger.info("--- postConstruct ---");
  }

  @PreDestroy
  public void preDestroy() {
    logger.info("--- preDestroy ---");
  }

  @PreDestroy
  public  void bye() {
    System.out.println("Bye from BinarySearch");
  }
}
