package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Card {
  private final Suit suit;
  private final Rank rank;

  // 3+ reasons to extract Rank as a separate Class
  // * Comparing card vs. another card
  // * Makes testing rank value private methods easier/possible
  // * Encapsulates logic into one place
  // * Validation
  // * Immutability
  // * Give it a name

  public Card(Suit suit, String rank) {
    this.suit = suit;
    this.rank = new Rank(rank);
  }

  public int rankValue() {
    return rank.rankValue();
  }

  public String display() {
    String[] lines = getDisplayCard();

    Ansi.Color cardColor = getCardColor();
    return getDisplayCard(lines, cardColor);
  }

  private String getDisplayCard(String[] lines, Ansi.Color cardColor) {
    return ansi()
        .fg(cardColor).toString()
        + String.join(ansi().cursorDown(1)
                            .cursorLeft(11)
                            .toString(), lines);
  }

  private String[] getDisplayCard() {
    String[] lines = new String[7];
    lines[0] = "┌─────────┐";
    lines[1] = String.format("│%s       │", rank.display());
    lines[2] = "│         │";
    lines[3] = String.format("│    %s    │", suit.display());
    lines[4] = "│         │";
    lines[5] = String.format("│       %s│", rank.display());
    lines[6] = "└─────────┘";
    return lines;
  }

  private Ansi.Color getCardColor() {
    return suit.getColor();
  }

  @Override
  public String toString() {
    return "Card {" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Card card = (Card) o;

    if (!suit.equals(card.suit)) return false;
    return rank.equals(card.rank);
  }

  @Override
  public int hashCode() {
    int result = suit.hashCode();
    result = 31 * result + rank.hashCode();
    return result;
  }
}
