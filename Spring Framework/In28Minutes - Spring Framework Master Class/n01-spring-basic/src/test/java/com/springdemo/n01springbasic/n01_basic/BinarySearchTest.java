package com.springdemo.n01springbasic.n01_basic;

import com.springdemo.n01springbasic.N01BasicSpringApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


// load the context
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = N01BasicSpringApplication.class)
class BinarySearchTest {

  // get this bean from the context
  @Autowired
  private BinarySearch binarySearch;

  @Test
  void successTest() {
    // call the method on binarySearch
    int actualResult = binarySearch.binarySearch(new int[]{}, 5);
    // check if the value is correct - we have hardcoded to 0 in binarySearch()
    assertEquals(0, actualResult);
  }

  @Test
  void failTest() {
    // call the method on binarySearch
    int actualResult = binarySearch.binarySearch(new int[]{}, 5);
    // check if the value is correct - we have hardcoded to 0 in binarySearch()
    assertEquals(5, actualResult);
  }
}