package com.chris.wrapper;

public class SampleWrapperTask {

  public static void main(String[] args) {
    int numbers = 120;
    Integer object = Integer.valueOf(numbers);
    double doubleNum = 121.00;
    Double object2 = Double.valueOf(doubleNum);
    int objValue = object.intValue();
    double obj2Value = object2.doubleValue();
  }
}
