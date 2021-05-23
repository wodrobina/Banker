package eu.wodrobina.transfer.dto;

import eu.wodrobina.account.model.BankAccount;

import java.math.BigDecimal;
import java.time.Instant;

public class MoneyTransferResult extends MoneyTransfer {

    private MoneyTransferResult(BankAccount from, BankAccount to, BigDecimal value, Instant timestamp) {
        super(from, to, value, timestamp);
    }

    public static MoneyTransferResult from(MoneyTransfer mt) {
        return new MoneyTransferResult(mt.getFrom(), mt.getTo(), mt.getValue(), mt.getTimestamp());
    }
}
