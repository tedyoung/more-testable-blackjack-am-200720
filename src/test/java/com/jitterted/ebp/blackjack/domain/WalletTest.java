package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletHasZeroDollars() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void add10DollarsToNewWalletShouldHaveBalanceOf10Dollars() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.balance())
        .isEqualTo(10);
  }

  @Test
  public void add5DollarsAnd10DollarsToNewWalletHasBalanceOf15Dollars() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(5);
    wallet.addMoney(10);

    assertThat(wallet.balance())
        .isEqualTo(15);
  }
}
