package com.chris.collections;

import java.util.HashMap;
/*
This is expected to return ConcurrentModificationException
But see another class I created called com.chris.collections.ConcurrentHashMapConcurrentExceptionExample.java to see how to fix it
 */

public class HashMapConcurrentExceptionExample {
  public static void main(String[] args) {

    HashMap<Integer, String> hashMap = new HashMap<>();

    hashMap.put(1, "100");
    hashMap.put(2, "101");
    hashMap.put(3, "102");

    Runnable runnable = () -> {
      try {
        Thread.sleep(1000);
        hashMap.put(4, "103");
      } catch (InterruptedException e) {
        System.out.println("Child Thread going to add element");
      }
    };

    Thread t = new Thread(runnable);
    t.start();
    for (Object o : hashMap.entrySet()) {
      try {
        System.out.println(o);
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
    }
    System.out.println(hashMap);

  }

}
