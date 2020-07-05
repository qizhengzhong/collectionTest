package com.chris.generics;

public interface AccountLogs {

  public void returnLog(String x, String y);
  public default String getLogs() {
    return "log captured ...";
  }

}
