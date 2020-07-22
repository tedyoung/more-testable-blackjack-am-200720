package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Hand;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit ARBITRARY_SUIT = Suit.HEARTS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    var cards = List.of(new Card(ARBITRARY_SUIT, "A"),
                        new Card(ARBITRARY_SUIT, "5"));

    Hand hand = new Hand(cards);


    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    var cards = List.of(new Card(ARBITRARY_SUIT, "A"),
                        new Card(ARBITRARY_SUIT, "8"),
                        new Card(ARBITRARY_SUIT, "3"));

    Hand hand = new Hand(cards);

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

}
