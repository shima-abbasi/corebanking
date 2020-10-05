package corebanking.customer.service;

import corebanking.customer.dto.RegisterCustomerRequestDTO;
import corebanking.customer.model.Customer;

public interface CustomerService {
    Customer registerCustomer(RegisterCustomerRequestDTO requestDTO);

    Customer findCustomerByNationalCode(String nationalCode);

    Customer findCustomerByCustomerNumber(String customerNumber);

}
