package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Suit;
import org.fusesource.jansi.Ansi;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SuitColorTest {

  @Test
  public void suitOfHeartsIsDisplayedInRed() throws Exception {

    assertThat(Suit.HEARTS.getColor())
        .isEqualTo(Ansi.Color.RED);
  }

  @Test
  public void suitOfSpadesIsDisplayedInBlack() throws Exception {

    assertThat(Suit.SPADES.getColor())
        .isEqualTo(Ansi.Color.BLACK);
  }

}
