package com.chris.test;

public class ExceptionTest {

  public static void main(String[] args) {

    for (int i=0; i<5; i++) {
      try {
        if (i == 3) {
          throw new IllegalArgumentException("new Exception");
        }
        System.out.println("This is at position " + i);
      } catch (IllegalArgumentException e) {
        System.out.println("Exception happened at " + i);
      }
    }
  }


}
