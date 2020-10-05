package corebanking.deposit.api;

import corebanking.common.dto.ApiDTO;
import corebanking.deposit.dto.CreateCustomerDepositRequestDTO;
import corebanking.deposit.dto.TransferBalanceToDepositRequestDTO;
import corebanking.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:api.properties")
public class DepositApi {
    @Autowired
    private DepositService depositService;

    @RequestMapping(value = "${DEPOSIT__GET_DEPOSIT_TYPE}", method = RequestMethod.GET)
    public ApiDTO getAllDepositTypes(){
        return new ApiDTO(Boolean.FALSE, "deposit_created_successful", depositService.getAllDepositTypes());
    }

    @RequestMapping(value = "${DEPOSIT__CREATE_CUSTOMER_DEPOSIT}", method = RequestMethod.POST)
    public ApiDTO createCustomerDeposit(@RequestBody CreateCustomerDepositRequestDTO requestDTO){
        return new ApiDTO(Boolean.FALSE, "deposit_created_successful", depositService.createCustomerDeposit(requestDTO));
    }

    @RequestMapping(value = "${DEPOSIT__TRANSFER_BALANCE_TO_DEPOSIT}", method = RequestMethod.POST)
    public ApiDTO transferBalanceToDeposit(@RequestBody TransferBalanceToDepositRequestDTO requestDTO){
        depositService.transferBalanceToDeposit(requestDTO);
        return new ApiDTO(Boolean.FALSE, "transfer_successful", null);

    }
}
