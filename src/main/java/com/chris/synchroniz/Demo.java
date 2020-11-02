package com.chris.synchroniz;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo implements Runnable {
  static AtomicInteger counter = new AtomicInteger(1); // a global counter

  static void incrementCounter() {
    System.out.println(Thread.currentThread().getName() + ": " + counter.getAndIncrement());
  }

  @Override
  public void run() {
    while (counter.get() < 1000) {
      incrementCounter();
    }
  }

  public static void main(String[] args) {
    Demo te = new Demo();
    Thread thread1 = new Thread(te);
    Thread thread2 = new Thread(te);

    thread1.start();
    thread2.start();
  }
}
