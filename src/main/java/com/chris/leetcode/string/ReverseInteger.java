package com.chris.leetcode.string;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Input: 123
 * Output: 321
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * 1111 - 8+4+2+1=15
 * 10*1+1*5
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reversePerfect(-2147483648));
  }

  public static int reversePerfect(int x) {
    if (x == 0)
      return 0;
    int res = 0;
    while (x != 0) {
      int lastDigit = x % 10;
      int newNumber = res * 10 + lastDigit;
      if ((newNumber - lastDigit) / 10 != res)
        return 0;
      res = newNumber;
      x = x / 10;
    }
    return res;
  }

  public static int reverse(int x) {
    if (x == Integer.MIN_VALUE)
      return 0;
    int cnt = 0;
    int temp = x;
    long finalValue = 0;
    while (Math.abs(temp) > 9) {
      temp = temp / 10;
      cnt++;
    }
    for (int i = cnt; i >= 0; i--) {
      finalValue += (x % 10) * Math.pow(10, i);
      if (finalValue < Integer.MIN_VALUE || finalValue > Integer.MAX_VALUE)
        return 0;
      x = x / 10;
    }
    return (int) finalValue;
  }
}
