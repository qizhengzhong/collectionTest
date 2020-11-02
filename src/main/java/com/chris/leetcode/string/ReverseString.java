package com.chris.leetcode.string;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] chars = {'h', 'e', 'l', 'm', 'o', 'a'};
    for (char i : reverseString(chars)) {
      System.out.println(i);
    }
  }

  public static char[] reverseString(char[] s) {
    int low = 0;
    int high = s.length - 1;
    while (low < high) {
      char temp = s[low];
      s[low] = s[high];
      s[high] = temp;
      low++;
      high--;
    }
    return s;
  }
}
