package eu.wodrobina.account.model.events;

import eu.wodrobina.account.model.BankAccountNumber;

import java.math.BigDecimal;
import java.time.Instant;

public record CashFlow(
        BankAccountNumber bankAccountNumber,
        BigDecimal value,
        Instant timestamp) {
}
