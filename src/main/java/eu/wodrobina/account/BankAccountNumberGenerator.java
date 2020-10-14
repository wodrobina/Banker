package eu.wodrobina.account;

import eu.wodrobina.account.model.BankAccountNumber;

public class BankAccountNumberGenerator {

    public BankAccountNumber generate() {
        String controlSum = "11";
        String sortCode = "222222222";
        String bankNumber = "3333333333333333";
        return new BankAccountNumber(controlSum + sortCode + bankNumber);
    }
}
