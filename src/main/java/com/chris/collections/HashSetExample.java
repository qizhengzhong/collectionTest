package com.chris.collections;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class HashSetExample {

  public static void main (String[] args) {
    HashSet<String> hashSet = new HashSet();
    hashSet.add("C");
    hashSet.add("A");
    hashSet.add("B");
    hashSet.add("A");
    hashSet.add("D");

    System.out.println(hashSet);

    List<String> list = hashSet.stream().collect(Collectors.toList());

    System.out.println(list);


  }

}
