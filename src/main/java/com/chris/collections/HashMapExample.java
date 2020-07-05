package com.chris.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample
{
  public static void main(String[] args)
  {
    HashMap<Integer, String> map = new HashMap<Integer, String>();

    map.put(1, "A");
    map.put(2, "B");
    map.put(3, "C");

    System.out.println("//Iterate over keys");

    Iterator<Integer> itr = map.keySet().iterator();

    while (itr.hasNext())
    {
      Integer key = itr.next();
      String value = map.get(key);

      System.out.println("The key is :: " + key + ", and value is :: " + value );
    }

    System.out.println("//Iterate over entries navigableset");

    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println("The key is :: " + entry.getKey() + ", and value is :: " + entry.getValue() );
    }
  }
}
