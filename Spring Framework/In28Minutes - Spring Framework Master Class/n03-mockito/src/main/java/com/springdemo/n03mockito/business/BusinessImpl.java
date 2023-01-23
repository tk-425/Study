package com.springdemo.n03mockito.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessImpl {

  private DataService dataService;

  @Autowired
  public BusinessImpl(DataService dataService) {
    this.dataService = dataService;
  }

  public int findTheGreatestFromAllData() {
    int[] data = dataService.retrieveAllData();

    int greatestValue = Integer.MIN_VALUE;
    for (int value : data) {
      if (value > greatestValue)
        greatestValue = value;
    }

    return greatestValue;
  }
}

interface DataService {
  int[] retrieveAllData();

  void noTestingNeeded();
}
