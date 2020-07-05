package com.chris.collections;

public class SimpleThreadExample extends Thread {

  public void run() {
    System.out.println("Inside " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    System.out.println("Inside " + Thread.currentThread().getName());

    SimpleThreadExample t = new SimpleThreadExample();

    t.start();
  }

}
