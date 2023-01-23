package com.springdemo.n03mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplStubTest {

  @Test
  void test1() {
    DataService serviceStub = new DataServiceStub1();
    BusinessImpl business = new BusinessImpl(serviceStub);
    int result = business.findTheGreatestFromAllData();
    assertEquals(74, result);
  }

  @Test
  void test2() {
    DataService serviceStub = new DataServiceStub2();
    BusinessImpl business = new BusinessImpl(serviceStub);
    int result = business.findTheGreatestFromAllData();
    assertEquals(0, result);
  }
}

/**
 * Stub Class
 * Problem with Stub method is when the interface adds new methods,
 * Stub class needs to implement those new methods
 * even if we do not need to test it.
 * Also, if we want to test more with stub class,
 * We have to create new stub classes for testing.
 */
class DataServiceStub1 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {25, 15, 74};
  }

  @Override
  public void noTestingNeeded() {}
}

class DataServiceStub2 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {0, 0, 0};
  }

  @Override
  public void noTestingNeeded() {}
}