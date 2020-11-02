package com.chris.builder;

public class BankAccount {

  private long accountNum;
  private String owner;
  private String branch;
  private double balance;
  private double interestRate;

  public long getAccountNum() {
    return accountNum;
  }

  public void setAccountNum(long accountNum) {
    this.accountNum = accountNum;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public static class UserBuilder {

  }
}
