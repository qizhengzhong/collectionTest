package com.chris.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * <p>
 * Example 1:
 * <p>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * <p>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {

  public static void main(String[] args) {
    int low = 1000;
    int high = 13000;
    List<Integer> arr = sequentialDigitsPerfect(low, high);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static List<Integer> sequentialDigitsPerfect(int low, int high) {
    List<Integer> result = new ArrayList<>();
    for (int digit = 1; digit < 10; digit++) {
      int next = digit;
      int number = digit;
      while (number <= high && next < 10) {
        if (number >= low)
          result.add(number);
        next += 1;
        number = number * 10 + next;
      }
    }
    //Return sorted result as per question
    Collections.sort(result);
    return result;
  }


  public static List<Integer> sequentialDigits(int low, int high) {
    List<Integer> retArray = new ArrayList<>();
    if (low > high || low < 10 || high > Math.pow(10, 9))
      return new ArrayList<>();
    int numBitsLow = (int) (Math.log10(low) + 1);
    int lowFirstDig = firstDigit(low);

    int count;
    while (true) {
      count = 0;
      if (lowFirstDig + numBitsLow > 10) {
        lowFirstDig = 1;
        numBitsLow++;
      }
      for (int i = 0; i < numBitsLow; i++) {
        count = (count * 10 + lowFirstDig + i);
      }
      if (count > high)
        break;
      if (count >= low) {
        retArray.add(count);
      }
      lowFirstDig++;

    }

    return retArray;
  }

  static int firstDigit(int x) {
    while (x > 9) {
      x /= 10;
    }
    return x;
  }

}
