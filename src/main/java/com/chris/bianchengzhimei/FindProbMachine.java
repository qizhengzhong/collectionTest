package com.chris.bianchengzhimei;

import java.util.HashMap;
import java.util.Map;

public class FindProbMachine {

  /**
   * I have a hashMap and I wanted to save the value only if the key not exists.
   * Otherwise, delete the whole entry
   */

  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();

    map.put(1, "12");

    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println(entry.getKey());
    }
  }
}
