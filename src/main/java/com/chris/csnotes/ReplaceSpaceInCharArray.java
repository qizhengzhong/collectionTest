package com.chris.csnotes;

/**
 * Input:
 * "A B"
 * <p>
 * Output:
 * "A%20B"
 */
public class ReplaceSpaceInCharArray {
  public static void main(String[] args) {
    String input = "A B";
    System.out.println(replace(input.toCharArray()));
  }

  private static String replace(char[] chars) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ' ') {
        sb.append("%20");
      } else {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }
}
