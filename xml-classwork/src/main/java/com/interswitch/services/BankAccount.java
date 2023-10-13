package com.interswitch.services;

public class BankAccount {

    private String accountNumber;

    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double depositFunds(double depositAmount) {
       return this.getBalance() + depositAmount;
    }

    public double withdrawFunds(double withdrawalAmount) {
        if (this.getBalance() < 0 || this.getBalance() < withdrawalAmount) {
            System.out.println("Insufficient balance for withdrawal");
        }else {
            return this.getBalance() - withdrawalAmount;
        }
        return this.getBalance();
    }
}
