package com.springdemo.n03mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BusinessImplMockTest {

  @Test
  void test1() {
    DataService serviceMock = mock(DataService.class);
    when(serviceMock.retrieveAllData()).thenReturn(new int[] {12, 5, 74});
    BusinessImpl business = new BusinessImpl(serviceMock);
    assertEquals(74, business.findTheGreatestFromAllData());
  }

  @Test
  void test2() {
    DataService serviceMock = mock(DataService.class);
    when(serviceMock.retrieveAllData()).thenReturn(new int[] {0, 0, 0});
    BusinessImpl business = new BusinessImpl(serviceMock);
    assertEquals(0, business.findTheGreatestFromAllData());
  }
}