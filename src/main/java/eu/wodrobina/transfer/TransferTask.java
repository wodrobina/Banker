package eu.wodrobina.transfer;

import eu.wodrobina.transfer.dto.MoneyTransfer;

public interface TransferTask<T, U extends MoneyTransfer> {
    U perform(T source);

    Class<T> handles();
}
