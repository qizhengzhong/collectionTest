package com.chris.CountdownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {
  public static void main(String args[]) {

    CountDownLatch latch = new CountDownLatch(4);
    Worker worker1 = new Worker(1000, latch, "Worker1");
    Worker worker2 = new Worker(4000, latch, "Worker2");
    Worker worker3 = new Worker(3000, latch, "Worker3");
    Worker worker4 = new Worker(2000, latch, "Worker4");

    try {
      worker1.start();
      worker2.start();
      worker3.start();
      worker4.start();
      latch.await();
    } catch (Exception e) {}

    System.out.println("Worker finished");

  }
}

class Worker extends Thread
{
  private int delay;
  private CountDownLatch latch;

  public Worker(int delay, CountDownLatch latch,
      String name)
  {
    super(name);
    this.delay = delay;
    this.latch = latch;
  }

  @Override
  public void run()
  {
    try
    {
      Thread.sleep(delay);
      latch.countDown();
      System.out.println(Thread.currentThread().getName()
          + " finished");
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
