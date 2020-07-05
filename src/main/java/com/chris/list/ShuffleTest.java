package com.chris.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ShuffleTest {
  public static void main(String[] args) {
    List list = Arrays.asList("a", "b", "c");
    System.out.println("List before shuffle is " + list);
    shuffle(list, new Random());
    System.out.println("List after shuffle is " + list);

    //Use Collections shuffle
    Collections.shuffle(list, new Random());
    System.out.println("List after collections shuffle is " + list);

    //get index of an element
    System.out.println(indexOf(list, null));

    //clear a sublist, need to be extendable
    List list_extendable = new ArrayList(list);
    list_extendable.subList(1,2).clear();
    System.out.println("List after clean up is " + list_extendable);
  }

  static void shuffle(List list, Random rnd) {
    for (int i = list.size(); i > 1; i--) {
      swap(list, i-1, rnd.nextInt(i));
    }
  }

  static void swap(List list, int i, int j) {
    Object tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  static int indexOf(List list, String e) {
    for (ListIterator<String> it = list.listIterator(); it.hasNext(); )
      if (e == null ? it.next() == null : e.equals(it.next()))
        return it.previousIndex();
    // Element not found
    return -1;
  }
}
