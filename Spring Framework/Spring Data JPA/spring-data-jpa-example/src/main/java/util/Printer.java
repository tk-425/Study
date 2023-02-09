package util;

import com.springdemo.example.entity.Member;

import java.util.List;

public class Printer<T> {
  public void printList(List<T> list) {
    System.out.println();
    for (T element : list) {
      System.out.println(element.toString());
    }
    System.out.println();
  }
}
