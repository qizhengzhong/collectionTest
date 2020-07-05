package com.chris.collections;

public class MultiFuncInterfaceExample
{
  interface FuncInt1 {
    int operation(int x, int y);
  }
  interface FuncInt2 {
    void sayMessage(String message);
  }

  private int runFuncInt1(int x, int y, FuncInt1 funcInt1) {
    return funcInt1.operation(x, y);
  }


  public static void main(String args[]) {
    FuncInt1 add = (int x, int y) -> x+y;
    FuncInt1 multi = (int x, int y) -> x*y;

    MultiFuncInterfaceExample test = new MultiFuncInterfaceExample();
    System.out.println(test.runFuncInt1(3,5, add));

    FuncInt2 print = (String m) -> System.out.println(m);

    print.sayMessage("testttt");
  }
}
