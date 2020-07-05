package com.chris.bianchengzhimei;

/**
 *
 */
public class XorTest {
  public static void main(String[] args) {
    String str1 = "1010100101";
    String str2 = "1110000101";
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str1.length(); i++) {
      sb.append(str1.charAt(i)^str2.charAt(i));
    }
    System.out.println(sb);
  }
}
