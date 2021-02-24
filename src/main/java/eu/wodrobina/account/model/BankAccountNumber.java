package eu.wodrobina.account.model;

import java.util.regex.Pattern;

public class BankAccountNumber {

    private static final int CONTROL_SUM_BEGIN = 0;
    private static final int CONTROL_SUM_END = 1;
    private static final int SORT_CODE_START = 2;
    private static final int SORT_CODE_END = 10;
    private static final int BANK_CODE_START = 11;
    private static final int BANK_CODE_END = 26;
    private static final int SIZE_OF_BANK_ACCOUNT_NUMBER = 26;

    private final String controlSum;
    private final String sortCode;
    private final String bankNumber;

    private final String bankAccountNumber;

    public BankAccountNumber(String bankAccountNumber) {
        isValid(bankAccountNumber);

        this.controlSum = bankAccountNumber.substring(CONTROL_SUM_BEGIN, CONTROL_SUM_END);
        this.sortCode = bankAccountNumber.substring(SORT_CODE_START, SORT_CODE_END);
        this.bankNumber = bankAccountNumber.substring(BANK_CODE_START, BANK_CODE_END);

        this.bankAccountNumber = combineBankAccountNumber();
    }

    private String combineBankAccountNumber() {
        return controlSum + sortCode + bankNumber;
    }

    private void isValid(String bankAccountNumber) {
        assert bankAccountNumber.length() == SIZE_OF_BANK_ACCOUNT_NUMBER;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return bankAccountNumber;
    }
}
