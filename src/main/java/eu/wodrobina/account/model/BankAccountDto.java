package eu.wodrobina.account.model;

import java.time.Instant;
import java.util.List;

public class BankAccountDto {

    private Instant creationTimestamp;
    private Instant closedTimestamp;
    private String bankAccountNumber;
    private List<AccountHistory> accountHistories;

    public BankAccountDto(final BankAccount bankAccount) {
        this.creationTimestamp = bankAccount.getCreationTimestamp();
        this.closedTimestamp = bankAccount.getClosedTimestamp();
        this.bankAccountNumber = bankAccount.getBankAccountNumber();
        this.accountHistories = bankAccount.getAccountHistories();
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public Instant getClosedTimestamp() {
        return closedTimestamp;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public List<AccountHistory> getAccountHistories() {
        return accountHistories;
    }
}
