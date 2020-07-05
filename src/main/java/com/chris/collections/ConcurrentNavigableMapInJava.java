package com.chris.collections;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/*
So this class ConcurrentNavigableMap will skip the first 3 an
 */
public class ConcurrentNavigableMapInJava {

  public static void main(String[] args) {
    ConcurrentNavigableMap<Integer, String> navigableMap = new ConcurrentSkipListMap<Integer, String>();

    navigableMap.put(1, "data1");
    navigableMap.put(2, "data2");
    navigableMap.put(3, "data3");
    navigableMap.put(4, "data4");

    ConcurrentNavigableMap<Integer, String> mapPointer = navigableMap.headMap(3);
    System.out.println(mapPointer);
  }
}
