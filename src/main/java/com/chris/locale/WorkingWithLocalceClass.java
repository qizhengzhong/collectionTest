package com.chris.locale;

import java.util.Locale;

public class WorkingWithLocalceClass {

  public static void main(String[] args) {
    Locale locale1 = new Locale("English", "IN");

    Locale locale2 = Locale.getDefault();

    System.out.println("local name " + locale1);
    System.out.println("local default name " + locale2);

    Locale locale3 = (Locale) locale2.clone();

    Locale[] locales = Locale.getAvailableLocales();
  }
}
