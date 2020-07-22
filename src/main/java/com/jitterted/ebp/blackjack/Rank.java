package com.jitterted.ebp.blackjack;

public class Rank {

  private String rank;

  public Rank(String rank) {
    this.rank = rank;
  }

  public int rankValue() {
    if (isFaceCard()) { // extract to query
      return 10;
    }
    if (isAce()) {
      return 1;
    }
    return numericValueOf(rank);
  }

  private int numericValueOf(String rank) {
    return Integer.parseInt(rank); // introduce parameter
  }

  private boolean isAce() {
    return rank.equals("A");
  }

  private boolean isFaceCard() {
    return "JQK".contains(rank);
  }

  public String display() {
    return rank + (rank.equals("10") ? "" : " ");
  }
}
