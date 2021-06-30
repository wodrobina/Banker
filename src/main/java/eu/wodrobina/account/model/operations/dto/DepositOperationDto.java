package eu.wodrobina.account.model.operations.dto;

import eu.wodrobina.account.model.operations.BankAccountOperation;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.function.Function;

public record DepositOperationDto(BigDecimal value, Instant timestamp) implements BankAccountOperation {

    public BigDecimal getValue() {
        return value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}
