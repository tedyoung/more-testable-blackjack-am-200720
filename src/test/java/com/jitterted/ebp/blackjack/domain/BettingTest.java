package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BettingTest {

  @Test
  public void newGameCreatesPlayerHaving100Dollars() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void playerBets10DollarsResultsInPlayerHaving90Dollars() throws Exception {
    Game game = new Game();

    game.playerBets(10);

    assertThat(game.playerBalance())
        .isEqualTo(90);
  }

  @Test
  public void playerBets20DollarsResultsInPlayersBetOf20Dollars() throws Exception {
    Game game = new Game();

    game.playerBets(20);

    assertThat(game.playerBet())
        .isEqualTo(20);
  }

  @Test
  public void playerBets15DollarsAndWinsResultsInPlayerHaving115DollarBalance() throws Exception {
    Game game = new Game();
    game.playerBets(15);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(115);
  }

  @Test
  public void playerLosesBetOf25DollarsResultsIn75DollarBalance() throws Exception {
    Game game = new Game();
    game.playerBets(25);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(75);
  }

  @Test
  public void playerBets30DollarsAndPushesResultsIn100DollarBalance() throws Exception {
    Game game = new Game();
    game.playerBets(30);

    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void playerBets50DollarsAndGetsBlackjackResultsIn175DollarBalance() throws Exception {
    Game game = new Game();
    game.playerBets(50);

    game.playerGetsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(100 + ((int) (50 * 1.5)));

  }

}
