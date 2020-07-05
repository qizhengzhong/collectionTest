package com.chris.collections;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableExample
{
  public static void main(String[] args)
  {
    //1. Create Hashtable
    Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

    //2. Add mappings to hashtable
    hashtable.put(3,  "C");
    hashtable.put(1,  "A");
    hashtable.put(2,  "B");


    System.out.println(hashtable);

    //3. Get a mapping by key
    String value = hashtable.get(1);        //A
    System.out.println(value);

    //4. Remove a mapping
    hashtable.remove(3);            //3 is deleted

    //5. Iterate over mappings
    Iterator<Integer> itr = hashtable.keySet().iterator();

    while(itr.hasNext())
    {
      Integer key = itr.next();
      String mappedValue = hashtable.get(key);

      System.out.println("Key: " + key + ", Value: " + mappedValue);
    }
  }
}
