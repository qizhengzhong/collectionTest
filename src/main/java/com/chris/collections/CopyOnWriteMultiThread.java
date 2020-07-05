package com.chris.collections;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteMultiThread {

  public static void main(String[] args) {
    CopyOnWriteGuruThread threadguru1 = new CopyOnWriteGuruThread("guru1");
    threadguru1.start();
    CopyOnWriteGuruThread threadguru2 = new CopyOnWriteGuruThread("guru2");
    threadguru2.start();
  }
}

class CopyOnWriteGuruThread implements Runnable {
  Thread guruthread;
  private String guruname;
  private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

  CopyOnWriteGuruThread(String name) {
    guruname = name;
  }

  @Override
  public void run() {
    System.out.println("Thread running  " + guruname);
    for (int i = 0; i < 4; i++) {
      list.add(i + "      " + guruname);
      System.out.println(list);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("Thread has been interrupted");
      }
    }
  }

  public void start() {
    System.out.println("Thread started");
    if (guruthread == null) {
      guruthread = new Thread(this, guruname);
      guruthread.start();
    }

  }
}
