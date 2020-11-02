package com.chris.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSupportTest {

  public static void main(String[] args) {
//    Set<String> navigableset = new TreeSet<>(Arrays.asList("Item1","Item2","Item3"));
//    Stream<String> stream = StreamSupport.stream(navigableset.spliterator(),true).filter(str -> str.length()>7);
//    stream.forEach(System.out::println);

    //Non-Interfearing Stream
    List<String> products = new ArrayList<>(Arrays.asList("product1","product2","product3","product4","product5"));

    Stream<String> vStream = products.parallelStream();
    products.add("product6");
    vStream.filter(str -> str.length()>3).map(String::toUpperCase)
        .sorted().forEach(System.out::println);
  }
}
