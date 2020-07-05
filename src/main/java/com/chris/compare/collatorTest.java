package com.chris.compare;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class collatorTest {

  public static void main(String[] args) throws ParseException {

    RuleBasedCollator basedCollator = (RuleBasedCollator) Collator.getInstance();

    System.out.println(basedCollator.getRules());

//    Collator mycollator = Collator.getInstance();
//
//    if (mycollator.compare("abc","ABC") < 0) {
//      System.out.println("abc is less than ABC");
//    } else {
//      System.out.println("abc is greater than ABC");
//    }
//
//    Collator uscollator = Collator.getInstance(Locale.US);
//
//    uscollator.setStrength(Collator.PRIMARY);
//    if (mycollator.compare("abc","ABC") == 0) {
//      System.out.println("abc is equal to ABC");
//    }

  }
}
