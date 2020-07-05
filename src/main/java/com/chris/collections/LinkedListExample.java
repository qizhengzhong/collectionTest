package com.chris.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample
{
  public static void main(String[] args)
  {
    LinkedList<String> linkedList = new LinkedList<String>();

    linkedList.add("A");
    linkedList.add("B");
    linkedList.add("C");
    linkedList.add("D");

    //1. LinkedList to Array
    String array[] = new String[linkedList.size()];

    linkedList.toArray(array);

    System.out.println(Arrays.toString(array));

    //2. Array to LinkedList
    LinkedList<String> linkedListNew = new LinkedList<String>(Arrays.asList(array));

    System.out.println(linkedListNew);
  }
}
