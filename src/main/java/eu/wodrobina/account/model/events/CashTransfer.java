package eu.wodrobina.account.model.events;

import eu.wodrobina.account.model.BankAccountNumber;

import java.time.Instant;

public class CashTransfer {
    private final BankAccountNumber fromBankAccountNumber;
    private final BankAccountNumber toBankAccountNumber;
    private final Instant timestamp = Instant.now();
    private final CashFlow cashFlowObservable;

    public CashTransfer(CashFlow cashFlowObservable,
                        BankAccountNumber fromBankAccountNumber,
                        BankAccountNumber toBankAccountNumber) {
        assert fromBankAccountNumber != null;
        assert toBankAccountNumber != null;
        this.cashFlowObservable = cashFlowObservable;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankAccountNumber = toBankAccountNumber;
    }

    public BankAccountNumber getFromBankAccountNumber() {
        return fromBankAccountNumber;
    }

    public BankAccountNumber getToBankAccountNumber() {
        return toBankAccountNumber;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public CashFlow getCashFlowObservable() {
        return cashFlowObservable;
    }
}
