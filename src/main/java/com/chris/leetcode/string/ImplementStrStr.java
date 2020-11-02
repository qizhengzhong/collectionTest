package com.chris.leetcode.string;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Constraints:
 * <p>
 * haystack and needle consist only of lowercase English characters.
 */
public class ImplementStrStr {

  public static void main(String[] args) {
    String haystack = "mississippi";
    String needle = "issipi";
    System.out.println(strStr(haystack, needle));
  }

  public static int strStr(String haystack, String needle) {
    if (needle.isEmpty())
      return 0;
    int needleSize = needle.length();
    int haystackSize = haystack.length();
    if (needleSize > haystackSize)
      return -1;
    char[] haystackChars = haystack.toCharArray();
    char[] needleChars = needle.toCharArray();
    for (int i = 0; i < haystackChars.length; i++) {
      if (haystackChars[i] == needleChars[0] && i + needleSize <= haystackSize && haystack
          .substring(i, i + needleSize).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

}
