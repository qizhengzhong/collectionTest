package com.chris.synchroniz;

import java.util.ArrayList;
import java.util.List;

/**
 * Use multiple thread to increment a counter
 */
public class Test {
  public static void main(String[] args) {
//    AtomicInteger counter = new AtomicInteger(1);
//    Runnable runnable = () -> {
//      while (counter.get() < 1000) {
//        System.out.println(counter.getAndIncrement());
//      }
//    };
//    Thread t1 = new Thread(runnable);
//    Thread t2 = new Thread(runnable);
//
//    t1.start();
//    t2.start();
    String str = "\uD835\uDD38";
    System.out.println(str);
    System.out.println(str.codePointCount(0, str.length()));

    List l = new ArrayList();
    l.add(null);
    l.add("1");
    l.add(null);
    System.out.println(l.get(2));
  }


}
