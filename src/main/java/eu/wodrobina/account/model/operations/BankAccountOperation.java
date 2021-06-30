package eu.wodrobina.account.model.operations;

import java.math.BigDecimal;
import java.time.Instant;

public interface BankAccountOperation {

    BigDecimal getValue();

    Instant getTimestamp();

}
