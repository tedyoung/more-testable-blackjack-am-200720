package com.jitterted.ebp.blackjack.domain;

public class Wallet {
  private int balance;

  public int balance() {
    return balance;
  }

  public void addMoney(int amount) {
    balance += amount;
  }
}
