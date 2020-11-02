package com.chris.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsTest {

  public static void main(String[] args) {

    List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 1, 3, 4));



    long sqNums = numbers.stream().map(n -> n * n).count();


    List<Integer> squareNum = numbers.stream().map(n -> n * n).collect(Collectors.toList());
    System.out.println(numbers.stream().sorted().collect(Collectors.toList()).get(numbers.size()-1));

//    numbers.add(5);
//
//    squareNum.forEach(System.out::println);

//
//    int sumOfEvenNumbers = numbers.stream().filter(x -> x%2==0).reduce(0,(out,i)->out+i);
//
//
//    System.out.println(sumOfEvenNumbers);
//    System.out.println(squareNum);
//    List<String> stringList = new ArrayList<String>();
//    stringList.add("ONE");
//    stringList.add("TWO");
//    stringList.add("THREE");
//
//    long count = stringList.stream().map(v -> {return v.toLowerCase();}).count();
//
//    System.out.println(count);
//    Stream.of("1","2","3","4","5")
//        .parallel()
//        .forEach(System.out::println);

  }
}
