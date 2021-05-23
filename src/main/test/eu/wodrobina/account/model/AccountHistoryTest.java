package eu.wodrobina.account.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class AccountHistoryTest {


    @Test
    @DisplayName("Should deposit")
    void test01() {

        AccountHistory accountHistory = new AccountHistory();
        BigDecimal deposit = accountHistory.deposit(BigDecimal.TEN);

        assertThat(deposit)
                .isEqualTo(BigDecimal.TEN);
    }

    @Test
    @DisplayName("Should withdraw")
    void test02() {

        AccountHistory accountHistory = new AccountHistory();
        BigDecimal deposit = accountHistory.withdraw(BigDecimal.TEN);

        assertThat(deposit)
                .isEqualTo(BigDecimal.TEN.negate());
    }

}