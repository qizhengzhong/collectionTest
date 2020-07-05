package com.chris.collections;

import java.util.concurrent.ConcurrentHashMap;

/*
HashMap is not syncrhonized in nature. i.e. HashMap is not thread-safe whereas ConcurrentHashMap is Thread-safe in nature
HashMap performance is relatively high because it is non-synchonized in nature and any number of thread
can perform simultaneously. But ConcurrentHashMap performance is low some times because sometimes Threads are
required to wait on ConcurrentHashMap
While one thread is iterating the HashMap object, if other thread try to add/modify the contents of object then
we will get Runtime exception saying concurrentModificationException. Whereas in ConcurrentHashMap we wont get
any exception while performing any modification at the time of iteration.
 */
public class ConcurrentHashMapExample {
  public static void main(String[] args) {
    ConcurrentHashMap m = new ConcurrentHashMap();;

    m.put(100, "Hello");
    m.put(101, "Chris");
    m.put(102, "Welcome");

    m.putIfAbsent(101, "Hello");

    m.putIfAbsent(103, "Hello");

    m.replace(101, "Chris", "For");

    System.out.println(m);

  }
}
