package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
  private final List<Card> cards = new ArrayList<>();

  public Hand() {
  }

  public Hand(List<Card> cards) {
    for (Card card : cards) {
      add(card);
    }
  }

  public void add(Card card) {
    cards.add(card);
  }

  public int value() {
    int handValue = cards
        .stream()
        .mapToInt(Card::rankValue)
        .sum();

    // does the hand contain at least 1 Ace?
    boolean hasAce = cards
        .stream()
        .anyMatch(card -> card.rankValue() == 1);

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }

  public void display() {
    System.out.println(cards.stream()
                            .map(Card::display)
                            .collect(Collectors.joining(
                                ansi().cursorUp(6).cursorRight(1).toString())));
  }


  public Card getCard(int index) {
    return cards.get(index);
  }

  boolean isBusted() {
    return value() > 21;
  }

  boolean beats(Hand dealerHand) {
    return value() > dealerHand.value();
  }

  boolean pushesWith(Hand hand) {
    return value() == hand.value();
  }
}
