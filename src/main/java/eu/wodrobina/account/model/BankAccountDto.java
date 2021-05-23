package eu.wodrobina.account.model;

import java.time.Instant;

public class BankAccountDto {

    private final Instant creationTimestamp;
    private final Instant closedTimestamp;
    private final String bankAccountNumber;

    public BankAccountDto(final BankAccount bankAccount) {
        this.creationTimestamp = bankAccount.getCreationTimestamp();
        this.closedTimestamp = bankAccount.getClosedTimestamp();
        this.bankAccountNumber = bankAccount.getBankAccountNumber();
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
}
