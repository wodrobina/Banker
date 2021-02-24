package eu.wodrobina.account.model;

import eu.wodrobina.account.model.events.CashFlow;
import eu.wodrobina.transfer.AcceptanceService;
import eu.wodrobina.transfer.StatisticService;
import eu.wodrobina.transfer.TransferManager;
import eu.wodrobina.transfer.TransferTask;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class AccountHistoryTest {


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

        CashFlow withdraw = bankAccount.withdraw(BigDecimal.valueOf(100));

        StatisticService statisticService = new StatisticService();
        AcceptanceService acceptanceService = new AcceptanceService();

        List<TransferTask<?, ?>> transferProcesses = List.of(acceptanceService, statisticService);

        TransferManager transferManager = new TransferManager(transferProcesses);

        transferManager.birthday(withdraw);




    }
}