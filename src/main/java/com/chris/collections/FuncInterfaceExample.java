package com.chris.collections;

import java.util.ArrayList;
import java.util.List;

public class FuncInterfaceExample {

  public static void main(String args[])
  {
    // Creating an ArrayList with elements
    // {1, 2, 3, 4}
    List<Integer> arrL = new ArrayList<>();
    arrL.add(1);
    arrL.add(2);
    arrL.add(3);
    arrL.add(4);

    // Using lambda expression to print all elements
    // of arrL
    arrL.forEach(n -> System.out.println(n));

    // Using lambda expression to print even elements
    // of arrL
    arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });
  }
}
