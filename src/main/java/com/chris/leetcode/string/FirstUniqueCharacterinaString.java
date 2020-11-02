package com.chris.leetcode.string;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 * <p>
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 * Note: You may assume the string contains only lowercase English letters.
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode"
 * return 2.
 */
public class FirstUniqueCharacterinaString {
  public static void main(String[] args) {
    long startmine = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      firstUniqChar("loveleetcode");
    }
    long finishmine = System.currentTimeMillis();
    long timeElapsedMine = finishmine - startmine;

    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      firstUniqCharFastest("loveleetcode");
    }
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("My bad method took " + timeElapsedMine);
    System.out.println("The fastest good method took " + timeElapsed);

  }

  public static int firstUniqCharFastest(String s) {
    if (s.isEmpty())
      return -1;
    int i = -1;
    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
      int x = s.indexOf(c);
      if (x >= 0 && (i == -1 || x < i) && x == s.lastIndexOf(c)) {
        i = x;
      }
    }
    return i;
  }

  public static int firstUniqChar(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int x = s.indexOf(chars[i]);
      if (x == s.lastIndexOf(chars[i]))
        return x;
    }
    return -1;
  }
}
