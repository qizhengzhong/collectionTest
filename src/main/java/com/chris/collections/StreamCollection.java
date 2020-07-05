package com.chris.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Color {
  RED("RED"),
  BLUE("BLUE");

  /**
   * Action type name
   */
  String name;

  Color(String s) {
    name = s;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
public class StreamCollection {

  public static void main(String[] args) {
    List myShapesCollection = new ArrayList();


    myShapesCollection.add(Color.BLUE);
    myShapesCollection.add(Color.BLUE);
    myShapesCollection.add(Color.RED);
    myShapesCollection.add(Color.RED);
    myShapesCollection.stream()
        .filter(e -> e == Color.RED)
        .forEach(e -> System.out.println("color"));

    String joined = (String) myShapesCollection.stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    System.out.println(joined);

  }
}
