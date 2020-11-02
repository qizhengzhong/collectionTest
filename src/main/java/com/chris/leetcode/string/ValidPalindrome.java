package com.chris.leetcode.string;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";

    System.out.println(isPalindromePerfect(s));
  }

  public static boolean isPalindromePerfect(String s) {

    char[] s_chars = s.toLowerCase().toCharArray();

    int i = 0;
    int j = s_chars.length - 1;

    while (i < j) {
      if (!Character.isLetterOrDigit(s_chars[i])) {
        i++;
        continue;
      }

      if (!Character.isLetterOrDigit(s_chars[j])) {
        j--;
        continue;
      }

      if (s_chars[i] != s_chars[j]) {
        return false;
      } else {
        i++;
        j--;
      }
    }

    return true;
  }

  public static boolean isPalindrome(String s) {
    if (s.trim().isEmpty())
      return true;
    s = s.toLowerCase();
    int lower = 0;
    int higher = s.length() - 1;
    if (higher == 0)
      return true;
    int validLength = s.length();
    while (lower < higher) {
      char chLower = s.charAt(lower);
      char chHigher = s.charAt(higher);

      if (!(((chLower - 'a') >= 0 && (chLower - 'a') <= 25) || ((chLower - '0') >= 0
          && (chLower - '0') <= 9))) { //Character.isLetterOrDigit(chLower);
        lower++;
        validLength--;
        continue;
      }
      if (!(((chHigher - 'a') >= 0 && (chHigher - 'a') <= 25) || ((chHigher - '0') >= 0
          && (chHigher - '0') <= 9))) {
        higher--;
        validLength--;
        continue;
      }
      if (chLower != chHigher)
        return false;

      lower++;
      higher--;
    }
    if (validLength == 1)
      return true;
    return true;
  }
}
