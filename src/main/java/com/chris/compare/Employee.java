package com.chris.compare;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

  private int employeeId;
  private String employeeName;
  private int age;

  public Employee(int employeeId, String employeeName, int age) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.age = age;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static Comparator<Employee> AgeComparator = (o1, o2) -> (o1.getAge() - o2.getAge());

  @Override public int compareTo(Employee o) {
    return (this.employeeId - o.employeeId);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "employeeId=" + employeeId +
        ", employeeName='" + employeeName + '\'' +
        ", age=" + age +
        '}';
  }
}
