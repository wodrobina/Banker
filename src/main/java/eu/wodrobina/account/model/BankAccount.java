package eu.wodrobina.account.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class BankAccount {

    private Instant creationTimestamp;
    private Instant closedTimestamp;
    private BankAccountNumber bankAccountNumber;
    private List<AccountHistory> accountHistories;

    private BankAccount(BankAccountNumber bankAccountNumber) {
        this.creationTimestamp = Instant.now();
        this.bankAccountNumber = bankAccountNumber;
        this.accountHistories = Collections.emptyList();
    }

    public static BankAccount open(BankAccountNumber bankAccountNumber) {
        return new BankAccount(bankAccountNumber);
    }

    public void deposit(BigDecimal amountToDeposit) {

    }

    public void withdraw(BigDecimal amountToWithdraw) {

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

    public List<AccountHistory> getAccountHistories() {
        return List.copyOf(accountHistories);
    }
}
