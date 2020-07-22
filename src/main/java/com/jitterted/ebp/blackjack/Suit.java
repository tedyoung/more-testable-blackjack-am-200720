package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

public enum Suit {
  HEARTS("♥", Ansi.Color.RED),
  SPADES("♠", Ansi.Color.BLACK),
  DIAMONDS("♦", Ansi.Color.RED),
  CLUBS("♣ ", Ansi.Color.BLACK);

  private final String display;
  private final Ansi.Color color;

  Suit(String display, Ansi.Color color) {
    this.display = display;
    this.color = color;
  }

  public String display() {
    return display;
  }

  public Ansi.Color getColor() {
    return color;
  }
}
