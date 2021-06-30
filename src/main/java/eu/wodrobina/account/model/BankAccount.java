package eu.wodrobina.account.model;

import eu.wodrobina.account.model.operations.AccountHistory;
import eu.wodrobina.account.model.operations.dto.DepositOperationDto;
import eu.wodrobina.account.model.operations.dto.WithdrawOperationDto;

import java.math.BigDecimal;
import java.time.Instant;

public class BankAccount {

    private Instant creationTimestamp;
    private Instant closedTimestamp;
    private BankAccountNumber bankAccountNumber;
    private AccountHistory accountHistory;

    private BankAccount(BankAccountNumber bankAccountNumber, AccountHistory accountHistory) {
        this.creationTimestamp = Instant.now();
        this.bankAccountNumber = bankAccountNumber;
        this.accountHistory = accountHistory;
    }

    public static BankAccount open(BankAccountNumber bankAccountNumber, AccountHistory accountHistory) {
        return new BankAccount(bankAccountNumber, accountHistory);
    }

    public BigDecimal deposit(DepositOperationDto toDeposit) {
        accountHistory.accept(toDeposit);
        return accountHistory.currentBalance();
    }

    public BigDecimal withdraw(WithdrawOperationDto toWithdraw) {
        accountHistory.accept(toWithdraw);
        return accountHistory.currentBalance();
    }

    public void close() {
        this.closedTimestamp = Instant.now();
    }

    private boolean isOpen() {
        return closedTimestamp == null;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public Instant getClosedTimestamp() {
        return closedTimestamp;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber.getBankAccountNumber();
    }

    public BigDecimal currentBalance() {
        return accountHistory.currentBalance();
    }
}
