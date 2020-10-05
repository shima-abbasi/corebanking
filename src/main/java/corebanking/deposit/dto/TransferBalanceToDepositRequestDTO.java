package corebanking.deposit.dto;


public class TransferBalanceToDepositRequestDTO {
    private String originDepositNumber;
    private long transferAmount;
    private String desDepositNumber;

    public String getOriginDepositNumber() {
        return originDepositNumber;
    }

    public void setOriginDepositNumber(String originDepositNumber) {
        this.originDepositNumber = originDepositNumber;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getDesDepositNumber() {
        return desDepositNumber;
    }

    public void setDesDepositNumber(String desDepositNumber) {
        this.desDepositNumber = desDepositNumber;
    }
}
