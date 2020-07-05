package com.chris.generics;

public class AccountActions implements AccountLogs {


  public void fundTransfer() {
    System.out.println(getLogs());
  }

  @Override public void returnLog(String x, String y) {

  }
}
