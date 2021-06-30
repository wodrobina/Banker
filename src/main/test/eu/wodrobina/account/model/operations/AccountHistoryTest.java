package eu.wodrobina.account.model.operations;

import eu.wodrobina.account.model.operations.dto.DepositOperationDto;
import eu.wodrobina.account.model.operations.dto.WithdrawOperationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class AccountHistoryTest {

    private AccountHistory accountHistory;

    @BeforeEach
    void setUp() {
        accountHistory = setupAccounthistory();
    }

    @Test
    @DisplayName("Should deposit")
    void test01() {

        DepositOperationDto toDeposit = new DepositOperationDto(BigDecimal.TEN, Instant.now());

        accountHistory.accept(toDeposit);
        BigDecimal currentBalance = accountHistory.currentBalance();

        assertThat(currentBalance)
                .isEqualTo(BigDecimal.TEN);
    }

    @Test
    @DisplayName("Should withdraw")
    void test02() {

        WithdrawOperationDto toWithdraw = new WithdrawOperationDto(BigDecimal.TEN, Instant.now());

        accountHistory.accept(toWithdraw);
        BigDecimal currentBalance = accountHistory.currentBalance();

        assertThat(currentBalance)
                .isEqualTo(BigDecimal.TEN.negate());
    }

    private static AccountHistory setupAccounthistory() {
        DepositHandler depositHandler = new DepositHandler();
        WithdrawHandler withdrawHandler = new WithdrawHandler();

        return new AccountHistory(Arrays.asList(depositHandler, withdrawHandler));
    }

}