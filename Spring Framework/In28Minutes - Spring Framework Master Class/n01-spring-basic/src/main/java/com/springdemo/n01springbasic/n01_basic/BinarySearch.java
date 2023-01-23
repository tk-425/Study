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
    int[] sortedArray = sortAlgorithm.sort(arr);

    // binary search algorithm goes here...

    // we'll just return 0 for now
    return 0;
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
