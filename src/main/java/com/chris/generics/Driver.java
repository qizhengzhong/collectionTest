package com.chris.generics;

public class Driver {

  public static void main(String[] args) {

    AccountActions object = new AccountActions();
    AccountLogs accountLogs = (x,y) -> System.out.println(x + "loggs" + y);

    accountLogs.returnLog("Hello ", " World");
    object.fundTransfer();
  }
}
