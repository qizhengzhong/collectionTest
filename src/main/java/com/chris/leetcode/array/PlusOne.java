package com.chris.leetcode.array;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 */
public class PlusOne {
  public static void main(String[] args) {
    int[] digits = {9};

    for (int i : plusOne(digits)) {
      System.out.println(i);
    }
  }

  public static int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }
    return addMostSigBit(digits);
  }

  public static int[] addMostSigBit(int[] digits) {
    int[] clone = new int[digits.length + 1];
    clone[0] = 1;
    return clone;
  }
}
