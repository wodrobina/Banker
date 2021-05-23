package eu.wodrobina.transfer;

import eu.wodrobina.account.model.BankAccount;
import eu.wodrobina.transfer.dto.MoneyTransfer;
import eu.wodrobina.transfer.dto.MoneyTransferResult;

class TransferHandler implements TransferTask<MoneyTransfer, MoneyTransferResult> {

    @Override
    public MoneyTransferResult perform(MoneyTransfer source) {
        BankAccount fromAccount = source.getFrom();
        BankAccount toAccount = source.getTo();
        toAccount.deposit(fromAccount.withdraw(source.getValue()));
        
        return MoneyTransferResult.from(source);
    }

    @Override
    public Class<MoneyTransfer> handles() {
        return MoneyTransfer.class;
    }
}
