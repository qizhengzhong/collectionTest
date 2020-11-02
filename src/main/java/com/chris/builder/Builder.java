package com.chris.builder;


/**
 * In the current specific case, we use the same fields as another class BankAccount
 * But we can still use multiple classes and call them within this class
 */
public class Builder {

  private long accountNum;
  private String owner;
  private String branch;
  private double balance;
  private double interestRate;

  //this is compulsory
  public Builder(long accountNum) {
    this.accountNum = accountNum;
  }

  public Builder withOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public Builder withBranch(String branch) {
    this.branch = branch;
    return this;
  }

  public Builder withBalance(double balance) {
    this.balance = balance;
    return this;
  }

  public Builder withInterest(double interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  public BankAccount build() {
    BankAccount bankAccount = new BankAccount();
    bankAccount.setAccountNum(this.accountNum);
    bankAccount.setOwner(this.owner);
    bankAccount.setBranch(this.branch);
    bankAccount.setBalance(this.balance);
    bankAccount.setInterestRate(this.interestRate);

    return bankAccount;
  }


}
