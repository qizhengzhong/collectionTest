package com.chris.collections;

import java.util.LinkedList;
import java.util.Queue;

public class CountDown {

  public static void main(String[] args) throws InterruptedException {
    int time = 5;
    Queue queue = new LinkedList<>();

    for (int i=0;i<time;i++) {
      queue.add(i);
    }
    while(!queue.isEmpty()) {
      System.out.println(queue.poll());
      Thread.sleep(1000);
    }
  }
}
