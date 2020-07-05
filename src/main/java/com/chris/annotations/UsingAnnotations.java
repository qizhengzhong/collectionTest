package com.chris.annotations;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface UserAnnotation
{
  String Employee() default "Alex";
  String dateOfJoining();
}

@interface RequestForEnhancement {
  int id();
  String synopsis();
  String engineer() default "unassigned";
  String date() default "unknown";
}
public class UsingAnnotations {

  @UserAnnotation(Employee = "Cody", dateOfJoining = "01-10-2019")
  public static void call1() {
    System.out.println("Call1........");
  }

  @UserAnnotation(Employee = "Chris", dateOfJoining = "04-15-2019")
  public static void call2() {
    System.out.println("Call2........");
  }
  public static void main(String[] args) {
    UsingAnnotations d1 = new UsingAnnotations();

    @NonNull
    String s =null;


    d1.call1();
    d1.call2();
    System.out.println("Test program");
  }
}
