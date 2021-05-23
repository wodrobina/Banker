package eu.wodrobina.transfer;

import eu.wodrobina.account.model.BankAccount;
import eu.wodrobina.account.model.BankAccountNumber;
import eu.wodrobina.transfer.dto.MoneyTransfer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TransferManagerTest {


    @Test
    void name() {
        String controlSum = "11";
        String sortCode = "222222222";
        String bankNumber = "333333333333333";
        String bankNumber2 = "444444444444444";
        BankAccountNumber bankAccountNumber = new BankAccountNumber(controlSum + sortCode + bankNumber);
        BankAccountNumber bankAccountNumber2 = new BankAccountNumber(controlSum + sortCode + bankNumber2);

        BankAccount bankAccount = BankAccount.open(bankAccountNumber);
        BankAccount bankAccount2 = BankAccount.open(bankAccountNumber2);

        TransferHandler transferHandler = new TransferHandler();
        List<TransferTask<?, ?>> transferProcesses = List.of(transferHandler);


        bankAccount.deposit(BigDecimal.valueOf(20));

        TransferManager transferManager = new TransferManager(transferProcesses);

        MoneyTransfer transfer = MoneyTransfer.transfer(bankAccount, bankAccount2, BigDecimal.TEN);
        MoneyTransfer moneyTransfer = transferManager.performTransfer(transfer);


        assertThat(bankAccount)
                .satisfies(ba -> assertThat(ba.currentBalance()).isEqualTo(BigDecimal.TEN));

        assertThat(bankAccount2)
                .satisfies(ba -> assertThat(ba.currentBalance()).isEqualTo(BigDecimal.TEN));


    }

}