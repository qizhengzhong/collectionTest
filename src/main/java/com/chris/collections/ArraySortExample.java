package com.chris.collections;

import java.util.Arrays;

public class ArraySortExample {

  public static void main(String[] args) {
    Integer[] list = new Integer[] {2,55,1,454,15,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,454,15,478,2,478,2,2,55,1,454,15,478,2,};

    long startTime = System.currentTimeMillis();
    for(long i=0;i<100000000; i++) {
      Arrays.sort(list);
    }
    long endTime = System.currentTimeMillis();

    System.out.println("Time spent for sorting Int list is " + (endTime-startTime) + " ms");

    long startTime2 = System.currentTimeMillis();
    for(long i=0;i<100000000; i++) {
      Arrays.parallelSort(list);
    }
    long endTime2 = System.currentTimeMillis();

    System.out.println("Time spent for sorting Int list is " + (endTime2-startTime2) + " ms");
  }
}
