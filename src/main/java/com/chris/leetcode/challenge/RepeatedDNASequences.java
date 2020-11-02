package com.chris.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 */
public class RepeatedDNASequences {
  static int NUM_REPEATED_CHAR = 10;
  public static void main(String[] args) {

//    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//    List<String> ret = findRepeatedDnaSequences(s);
//    for (String st: ret) {
//      System.out.println(st);
//    }

    int x = 2;

    if (!(x==0 ||x==2)) {
      System.out.println("here step 1" + x);
    } else {
      System.out.println(x);
    }
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length()<=10) {
      return new ArrayList<>();
    }
    int length = s.length();
    for (int i=0; i<length; i++) {
      String subStr = s.substring(i, i+NUM_REPEATED_CHAR);
    }
    List<String> retArr = new ArrayList<>();

    return retArr;
  }

}
