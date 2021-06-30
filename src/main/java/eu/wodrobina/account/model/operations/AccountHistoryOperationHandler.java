package eu.wodrobina.account.model.operations;

import java.math.BigDecimal;
import java.util.function.Function;

public interface AccountHistoryOperationHandler<T extends BankAccountOperation> {

    Function<T, BigDecimal> handle();

    Class handles();
}
