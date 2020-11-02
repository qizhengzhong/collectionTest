package com.chris.lock;

import static java.lang.Thread.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    ReentrantLock lock = new ReentrantLock();

    executorService.submit(() -> {
      lock.lock();

      try {
        sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
          lock.unlock();
        }
    });

    executorService.submit(() -> {
      System.out.println("Locked " + lock.isLocked());
      System.out.println("Held by me " + lock.isHeldByCurrentThread());
      boolean locked = lock.tryLock();
      System.out.println("lock acquired " + locked);
    });

    executorService.shutdown();
  }
}
