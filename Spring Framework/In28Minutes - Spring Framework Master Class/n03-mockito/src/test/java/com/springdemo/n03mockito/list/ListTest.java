package com.springdemo.n03mockito.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListTest {

  private final List listMock = mock(List.class);

  @Test
  void simpleTest() {
    when(listMock.size()).thenReturn(3);

    assertEquals(3, listMock.size());
  }

  @Test
  void multipleReturns() {
    when(listMock.size()).thenReturn(1).thenReturn(2);

    assertEquals(1, listMock.size());
    assertEquals(2, listMock.size());
  }

  @Test
  void specificParameters() {
    when(listMock.get(0)).thenReturn("Some String...");

    assertEquals("Some String...", listMock.get(0));
    assertNull(listMock.get(1));
  }

  @Test
  void genericParameters() {
    when(listMock.get(Mockito.anyInt())).thenReturn("Some Other String...");

    assertEquals("Some Other String...", listMock.get(0));
    assertEquals("Some Other String...", listMock.get(1));
  }
}