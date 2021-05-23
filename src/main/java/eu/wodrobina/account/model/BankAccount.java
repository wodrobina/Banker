package eu.wodrobina.account.model;

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

    public static BankAccount open(BankAccountNumber bankAccountNumber) {
        return new BankAccount(bankAccountNumber, new AccountHistory());
    }

    public BigDecimal deposit(BigDecimal amount) {
        return accountHistory.deposit(amount);
    }

    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        return accountHistory.withdraw(amountToWithdraw);
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
