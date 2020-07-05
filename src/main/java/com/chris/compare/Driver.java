package com.chris.compare;

import java.util.Arrays;

public class Driver {

  public static void main(String[] args) {
    Employee[] employees = new Employee[2];
    Employee e1 = new Employee(1,"ruby",32);
    Employee e2 = new Employee(2,"chris",35);

    employees[0] = e1;
    employees[1] = e2;

    System.out.println(e1.compareTo(e2));

    Arrays.sort(employees, Employee.AgeComparator);

    System.out.println(Arrays.toString(employees));
  }
}
