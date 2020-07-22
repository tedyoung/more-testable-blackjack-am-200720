package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CardTest {

  private static final Suit ARBITRARY_SUIT = Suit.HEARTS;

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    Card card = new Card(ARBITRARY_SUIT, "7");

    assertThat(card.rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    Card card = new Card(ARBITRARY_SUIT, "Q");

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withValueOfJackHasNumericValueOf10() throws Exception {
    Card card = new Card(ARBITRARY_SUIT, "J");

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withValueOfKingHasNumericValueOf10() throws Exception {
    Card card = new Card(ARBITRARY_SUIT, "K");

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    Card card = new Card(ARBITRARY_SUIT, "A");

    assertThat(card.rankValue())
        .isEqualTo(1);
  }


}