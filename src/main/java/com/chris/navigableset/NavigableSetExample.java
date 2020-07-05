package com.chris.navigableset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {

  public static void main(String[] args) {
    NavigableSet<String> navigableSet = new TreeSet<String>();
    navigableSet.add("data1");
    navigableSet.add("data3"); // in the second position
    navigableSet.add("data2");

    System.out.println("Normal View");
    System.out.println(navigableSet);
    System.out.println("ReverseView");
    NavigableSet<String> reverseNavigableSet = navigableSet.descendingSet();
    System.out.println(reverseNavigableSet);
  }
}
