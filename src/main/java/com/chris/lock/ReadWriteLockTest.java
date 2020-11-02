package com.chris.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    Map<String, String> map = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    executorService.submit(() -> {
      lock.writeLock().lock();

      try {
        map.put("foo","bar");
      } catch (Exception e) {
      } finally {
        lock.writeLock().unlock();
      }
    });
    Runnable runnable = () -> {
      lock.readLock().lock();

      try {
        System.out.println(map.get("foo"));
      } catch (Exception e) {
      } finally {
        lock.readLock().unlock();
      }
    };

    executorService.submit(runnable);
    executorService.submit(runnable);
    executorService.shutdown();
  }
}
