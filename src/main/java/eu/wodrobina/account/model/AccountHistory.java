package eu.wodrobina.account.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.Queue;

public class AccountHistory {

    private final Queue<BigDecimal> history = new LinkedList();

    public BigDecimal currentBalance() {
        return history.stream()
                .reduce((a, b) -> a.add(b, MathContext.UNLIMITED))
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal deposit(BigDecimal amount) {
        history.add(amount);
        return currentBalance();
    }

    public BigDecimal withdraw(BigDecimal amount) {
        history.add(amount.negate());
        return currentBalance();
    }
}
