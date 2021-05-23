package eu.wodrobina.transfer.dto;

import eu.wodrobina.account.model.BankAccount;

import java.math.BigDecimal;
import java.time.Instant;

public class MoneyTransfer {

    private final BankAccount from;
    private final BankAccount to;
    private final BigDecimal value;
    private final Instant timestamp;

    public MoneyTransfer(BankAccount from, BankAccount to,
                         BigDecimal value, Instant timestamp) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.timestamp = timestamp;
    }

    public static MoneyTransfer transfer(BankAccount from, BankAccount to, BigDecimal value) {
        return new MoneyTransfer(from, to, value, Instant.now());
    }

    public BankAccount getFrom() {
        return from;
    }

    public BankAccount getTo() {
        return to;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
