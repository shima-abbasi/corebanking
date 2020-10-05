package corebanking.deposit.dto;


public class CreateCustomerDepositRequestDTO {
    private String customerNumber;
    private String depositTypeCode;
    private long initialBalance;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDepositTypeCode() {
        return depositTypeCode;
    }

    public void setDepositTypeCode(String depositTypeCode) {
        this.depositTypeCode = depositTypeCode;
    }

    public long getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(long initialBalance) {
        this.initialBalance = initialBalance;
    }
}
