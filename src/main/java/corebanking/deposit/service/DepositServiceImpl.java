package corebanking.deposit.service;

import corebanking.common.systemConfig.model.SystemConfig;
import corebanking.common.systemConfig.service.SystemConfigService;
import corebanking.deposit.config.DepositPropertiesService;
import corebanking.deposit.config.DepositTypePropertiesService;
import corebanking.deposit.dto.CreateCustomerDepositRequestDTO;
import corebanking.deposit.dto.TransferBalanceToDepositRequestDTO;
import corebanking.deposit.model.Deposit;
import corebanking.deposit.repository.DepositRepo;
import corebanking.customer.model.Customer;
import corebanking.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DepositRepo depositRepo;
    @Autowired
    private SystemConfigService config;
    @Autowired
    private DepositTypePropertiesService depositTypeConfig;
    @Autowired
    private DepositPropertiesService depositConfig;
    @Autowired
    private TransactionService transactionService;

    @Override
    public List<SystemConfig> getAllDepositTypes() {
        return config.getConfigByParentCode(depositTypeConfig.getConfigParentCode());
    }

    @Override
    public Deposit createCustomerDeposit(CreateCustomerDepositRequestDTO requestDTO) {
        return initiateDeposit(requestDTO);
    }

    @Override
    public void transferBalanceToDeposit(TransferBalanceToDepositRequestDTO requestDTO) {
        Deposit originDeposit = depositRepo.findByDepositNumber(requestDTO.getOriginDepositNumber());
        Deposit desDeposit = depositRepo.findByDepositNumber(requestDTO.getDesDepositNumber());
        originDeposit.setBalance(originDeposit.getBalance() - requestDTO.getTransferAmount());
        depositRepo.atomSave(originDeposit);
        desDeposit.setBalance(desDeposit.getBalance() + requestDTO.getTransferAmount());
        depositRepo.atomSave(desDeposit);
        transactionService.initiateTransation("withdraw to " + desDeposit.getDepositNumber(), originDeposit.getCustomer());
        transactionService.initiateTransation("deposit from " + originDeposit.getDepositNumber() , desDeposit.getCustomer());
    }

    private Deposit initiateDeposit(CreateCustomerDepositRequestDTO requestDTO){
        Customer customer = customerService.findCustomerByCustomerNumber(requestDTO.getCustomerNumber());
        String depositNumber = generateDepositNumber(requestDTO.getCustomerNumber(), requestDTO.getDepositTypeCode());
        Deposit deposit = new Deposit(customer, depositNumber, requestDTO.getInitialBalance());
        depositRepo.atomSave(deposit);
        return deposit;
    }

    private String generateDepositNumber(String customerNumber, String depositTypeCode){
        SystemConfig depositType = config.getConfigByCode(depositTypeCode);
        return depositConfig.getValue(DepositPropertiesService.MY_BANK_CODE) + "." + depositType.getValue() + "." + customerNumber;
    }
}
