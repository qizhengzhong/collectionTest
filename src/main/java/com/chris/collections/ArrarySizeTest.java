package com.chris.collections;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrarySizeTest {

  public static void main(String[] args)
  {
    int oldCapacity = 10; // 1010 -> 101
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    System.out.println(newCapacity);
  }
}
