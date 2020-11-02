package com.chris.leetcode.string;

import java.util.Arrays;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    if (isAnagramOnline(s, t))
      System.out.println("It is an anagram, congrats!");
    else
      System.out.println("That's not an anagram.");

  }

  public static boolean isAnagramOnline(String s, String t) {
    if (s.length() != t.length())
      return false;
    int[] counter = new int[26];

    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int c : counter) {
      if (c != 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;
    char[] chars_s = s.toCharArray();
    char[] chars_t = t.toCharArray();
    Arrays.sort(chars_s);
    Arrays.sort(chars_t);

    return Arrays.equals(chars_s, chars_t);
  }

}
