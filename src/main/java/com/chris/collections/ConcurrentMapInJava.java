package com.chris.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapInJava {

  public static void main(String[] args) {
    ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<Integer, String>();

    concurrentMap.put(1, "data1");
    concurrentMap.put(2, "data2");

    System.out.println(concurrentMap.get(1));
  }
}
