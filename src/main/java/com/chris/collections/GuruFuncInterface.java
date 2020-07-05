package com.chris.collections;

public interface GuruFuncInterface {

  void test(int x);

  public default void defTest(int y) {
    System.out.println(y);
  }
}
