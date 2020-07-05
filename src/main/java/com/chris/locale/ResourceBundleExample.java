package com.chris.locale;

import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * I have to have my bundles in my resources
 */
public class ResourceBundleExample {
  public static void main(String[] args) {

    ClassLoader cl = ClassLoader.getSystemClassLoader();

    URL[] urls = ((URLClassLoader) cl).getURLs();

    for (URL url : urls) {
      System.out.println(url.getFile());
    }

    System.out.println("Current locale : " + Locale.getDefault());

    ResourceBundle mybundle = ResourceBundle.getBundle("hello");

    System.out.println("Say how are you in US English" + mybundle.getString("first_name"));

    Locale.setDefault(new Locale("en", "IN"));

    System.out.println("Current Locale: " + Locale.getDefault());
    mybundle = ResourceBundle.getBundle("hello");

    System.out.println("Say how are you in IN English" + mybundle.getString("first_name"));

    Formatter formatter = new Formatter();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

  }
}
