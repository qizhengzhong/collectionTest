package com.chris.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapConcurrentExceptionExample {
  public static void main(String[] args) {

    ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    concurrentHashMap.put(1, "100");
    concurrentHashMap.put(2, "101");
    concurrentHashMap.put(3, "102");

    Runnable runnable = () -> {
      try {
        Thread.sleep(1000);
        concurrentHashMap.put(4, "103");
      } catch (InterruptedException e) {
        System.out.println("Child Thread going to add element");
      }
    };

    Thread t = new Thread(runnable);
    t.start();
    for (Object o : concurrentHashMap.entrySet()) {
      try {
        System.out.println(o);
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
    }
    System.out.println(concurrentHashMap);

  }

}
