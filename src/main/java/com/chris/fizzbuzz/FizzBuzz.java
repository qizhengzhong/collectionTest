package com.chris.fizzbuzz;

public class FizzBuzz {

  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      String test = "";
      test += (i % 3) == 0 ? "Fizz" : "";
      test += (i % 5) == 0 ? "Buzz" : "";
      System.out.println(!test.isEmpty() ? test : i);
    }
  }
}
