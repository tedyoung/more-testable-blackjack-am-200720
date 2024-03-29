package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

  private final Deck deck;

  private final Hand dealerHand = new Hand();
  private final Hand playerHand = new Hand();
  private int playerBalance;
  private int playerBet;

  public static void main(String[] args) {
    showWelcomeScreen();

    playGame();

    resetScreen();
  }

  private static void playGame() {
    Game game = new Game();
    game.initialDeal();
    game.play();
  }

  private static void resetScreen() {
    System.out.println(ansi().reset());
  }

  private static void showWelcomeScreen() {
    System.out.println(ansi()
                           .bgBright(Ansi.Color.WHITE)
                           .eraseScreen()
                           .cursor(1, 1)
                           .fgGreen().a("Welcome to")
                           .fgRed().a(" Jitterted's")
                           .fgBlack().a(" BlackJack"));
  }

  public Game() {
    deck = new Deck();
    playerBalance = 100;
  }

  public void initialDeal() {

    // deal first round of cards, players first
    dealRoundOfCards();

    // deal next round of cards
    dealRoundOfCards();
  }


  private void dealRoundOfCards() {
    playerHand.add(deck.draw());
    dealerHand.add(deck.draw());
  }

  public void play() {
    boolean playerBusted = playerPlays();

    dealerPlays(playerBusted);

    displayFinalGameState();

    finalGameResults(playerBusted);
  }

  private void finalGameResults(boolean playerBusted) {
    if (playerBusted) {
      System.out.println("You Busted, so you lose.  💸");
    } else if (dealerHand.isBusted()) {
      System.out.println("Dealer went BUST, Player wins! Yay for you!! 💵");
    } else if (playerBeatsDealer()) {
      System.out.println("You beat the Dealer! 💵");
    } else if (playerHand.pushesWith(dealerHand)) {
      System.out.println("Push: The house wins, you Lose. 💸");
    } else {
      System.out.println("You lost to the Dealer. 💸");
    }
  }

  private boolean playerBeatsDealer() {
    return playerHand.beats(dealerHand);
  }

  private void dealerPlays(boolean playerBusted) {
    // Dealer makes its choice automatically based on a simple heuristic (<=16, hit, 17>stand)
    if (!playerBusted) {
      while (dealerHand.value() <= 16) {
        dealerHand.add(deck.draw());
      }
    }
  }

  private boolean playerPlays() {
    // get Player's decision: hit until they stand, then they're done (or they go bust)
    boolean playerBusted = false;
    while (!playerBusted) {
      displayGameState();
      String playerChoice = inputFromPlayer().toLowerCase();
      if (playerChoice.startsWith("s")) {
        break;
      }
      if (playerChoice.startsWith("h")) {
        playerHand.add(deck.draw());
        if (playerHand.isBusted()) {
          playerBusted = true;
        }
      } else {
        System.out.println("You need to [H]it or [S]tand");
      }
    }
    return playerBusted;
  }


  private String inputFromPlayer() {
    System.out.println("[H]it or [S]tand?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private void displayGameState() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    System.out.println(dealerHand.getCard(0).display()); // first card is Face Up

    // second card is the hole card, which is hidden
    displayBackOfCard();

    System.out.println();
    System.out.println("Player has: ");
    playerHand.display();
    System.out.println(" (" + playerHand.value() + ")");
  }

  private void displayBackOfCard() {
    System.out.print(
        ansi()
            .cursorUp(7)
            .cursorRight(12)
            .a("┌─────────┐").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("└─────────┘"));
  }

  private void displayFinalGameState() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    dealerHand.display();
    System.out.println(" (" + dealerHand.value() + ")");

    System.out.println();
    System.out.println("Player has: ");
    playerHand.display();
    System.out.println(" (" + playerHand.value() + ")");
  }

  public int playerBalance() {
    return playerBalance;
  }

  public void playerBets(int amount) {
    playerBalance -= amount;
    playerBet = amount;
  }

  public int playerBet() {
    return playerBet;
  }

  public void playerWins() {
    playerBalance += playerBet * 2;
  }

  public void playerLoses() {

  }

  public void playerPushes() {
    playerBalance += playerBet;
  }

  public void playerGetsBlackjack() {
    playerBalance += playerBet * 2.5;
  }
}
