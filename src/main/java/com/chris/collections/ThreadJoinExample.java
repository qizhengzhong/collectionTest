package com.chris.collections;/*
thread waits until another thread finishes
 */

public class ThreadJoinExample {

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      System.out.println("Entered Thread 1");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      System.out.println("Exiting Thread 1");
    });
    Thread thread2 = new Thread(() -> {
      System.out.println("Entered Thread 2");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      System.out.println("Exiting Thread 2");
    });

    System.out.println("Starting Thread 1");
    thread1.start();

    System.out.println("Waiting for Thread 1 to complete");

    try {
      thread1.join(1000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }

    System.out.println("Waited enough! Starting Thread 2 now");
    thread2.start();
  }
}
