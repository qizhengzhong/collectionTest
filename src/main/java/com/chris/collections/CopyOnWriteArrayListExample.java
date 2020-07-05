package com.chris.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

  public static void main(String[]  args) {

    CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList(new Integer[] {1,2,3});

    System.out.println(list);

    Iterator iterator1 = list.iterator();

    list.add(4);

    System.out.println(list);

    Iterator iterator2 = list.iterator();

    iterator1.forEachRemaining(System.out::println);
    iterator2.forEachRemaining(System.out::println);
  }
}
