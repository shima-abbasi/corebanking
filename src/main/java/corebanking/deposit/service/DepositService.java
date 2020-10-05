package corebanking.deposit.service;

import corebanking.common.systemConfig.model.SystemConfig;
import corebanking.deposit.dto.CreateCustomerDepositRequestDTO;
import corebanking.deposit.dto.TransferBalanceToDepositRequestDTO;
import corebanking.deposit.model.Deposit;

import java.util.List;

public interface DepositService {
    List<SystemConfig> getAllDepositTypes();

    Deposit createCustomerDeposit(CreateCustomerDepositRequestDTO requestDTO);

    void transferBalanceToDeposit(TransferBalanceToDepositRequestDTO requestDTO);
}
