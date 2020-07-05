package com.chris.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildCard {

  public static void viewData(List<?> listItems) {
    for (Object object:listItems){
      System.out.println(object);
    }
  }

  //Concept of PECS, producer extends Consumer super
  //Producer make it more specific and consumer make it more general
  public static void integerElements(List<? super Integer> dataItem) {
    dataItem.add(100);
  }
  public static void main(String[] args) {
    List<String> dataItems = new ArrayList<String>();
    dataItems.add("data1");
    dataItems.add("data2");
    dataItems.add("data3");
    viewData(dataItems);
    ArrayList<Integer> integerData = new ArrayList<>();
    integerElements(integerData);
    viewData(integerData);
  }
}
