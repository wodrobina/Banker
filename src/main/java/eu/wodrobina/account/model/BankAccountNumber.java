package eu.wodrobina.account.model;

public class BankAccountNumber {

    public static final int CONTROL_SUM_BEGIN = 0;
    public static final int CONTROL_SUM_END = 1;
    public static final int SORT_CODE_START = 2;
    public static final int SORT_CODE_END = 10;
    public static final int BANK_CODE_START = 11;
    public static final int BANK_CODE_END = 26;
    public static final int SIZE_OF_BANK_ACCOUNT_NUMBER = 26;
    public static final String ONLY_DIGITS = "[0-9]+";

    private String controlSum;
    private String sortCode;
    private String bankNumber;

    private String bankAccountNumber;

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
        assert bankAccountNumber.contains(ONLY_DIGITS);
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
}
