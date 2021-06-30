package eu.wodrobina.account.model.operations;

import eu.wodrobina.account.model.operations.AccountHistoryOperationHandler;
import eu.wodrobina.account.model.operations.BankAccountOperation;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountHistory {

    private final Queue<BankAccountOperation> operationHistory = new LinkedList();
    private final Map<Class, Function<BankAccountOperation, BigDecimal>> valueHandlers;

    public AccountHistory(List<AccountHistoryOperationHandler> handlers) {
        this.valueHandlers = handlers.stream()
                .collect(Collectors.toMap(a -> a.handles(), b -> b.handle()));
    }

    public void accept(BankAccountOperation accountOperation) {
        operationHistory.add(accountOperation);
    }

    public BigDecimal currentBalance() {
        return operationHistory.stream()
                .map(operation -> valueHandlers.get(operation.getClass()).apply(operation))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
