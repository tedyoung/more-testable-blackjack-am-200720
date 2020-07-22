package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Hand;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit ARBITRARY_SUIT = Suit.HEARTS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "5");

    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  @Test
  public void handWithAceAndOtherCardsEqualTo9ThenAceIsValuedAt11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

  @Test
  public void handWithAceAndOtherCardsEqualTo10IsValuedAt21() throws Exception {
    Hand hand = createHandWithRanksOf("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void aceWithOtherCardsEqualTo12ThenAceIsValuedAt1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "9", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 9 + 3);
  }

  @Test
  public void fourAcesOnlyOneAceCountedAs11OthersAs1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "A", "A", "A");

    assertThat(hand.value())
        .isEqualTo(11 + 1 + 1 + 1);
  }

  private Hand createHandWithRanksOf(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(ARBITRARY_SUIT, rank));
    }
    return new Hand(cards);
  }

}
