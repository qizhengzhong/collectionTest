package com.chris.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
//test unmodifiable set
public class ConvenientFactorySample {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(100);
    set.add(200);
    set = Collections.unmodifiableSet(set);
    set.add(500);

  }
}
