package com.chris.collections;

public class SimpleRunnableExample implements Runnable {
  @Override public void run() {
    System.out.println("Inside " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    System.out.println("Inside " + Thread.currentThread().getName());

    Runnable r = new SimpleRunnableExample();

    Thread t = new Thread(r);
    t.start();

  }
}
