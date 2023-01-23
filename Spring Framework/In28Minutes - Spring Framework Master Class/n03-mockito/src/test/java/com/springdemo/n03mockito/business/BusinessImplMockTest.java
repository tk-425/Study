package com.springdemo.n03mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BusinessImplMockTest {

  @Mock
  private DataService dataServiceMock;

  @InjectMocks
  private BusinessImpl business;

  @Test
  void test1() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {12, 5, 74});
    assertEquals(74, business.findTheGreatestFromAllData());
  }

  @Test
  void test2() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {0, 0, 0});
    assertEquals(0, business.findTheGreatestFromAllData());
  }
}