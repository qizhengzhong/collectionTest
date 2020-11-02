package com.chris.builder;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {

  public static void main(String[] args) {
    ReentrantLock x = new ReentrantLock();
    BankAccount bankAccount = new Builder(12456L).withBalance(111L).withBranch("Galway").withOwner("Chris").withInterest(1L).build();

    System.out.println(bankAccount.getAccountNum());
  }
}
