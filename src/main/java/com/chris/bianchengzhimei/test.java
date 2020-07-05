package com.chris.bianchengzhimei;

public class test {
  private static final String COMMA = ",";

  public static void main(String[] args) {

    String tags = "abc, bdijfe, dfd";
    String[] tagsStr = tags.split(COMMA);

    for (String t: tagsStr) {
      System.out.println(t);
    }




  }
}
