package corebanking.customer.service;

import corebanking.customer.Util.IdGenerator;
import corebanking.customer.dto.RegisterCustomerRequestDTO;
import corebanking.customer.exception.CustomerException;
import corebanking.customer.model.Customer;
import corebanking.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer registerCustomer(RegisterCustomerRequestDTO requestDTO) {
        if(customerRepo.findByNationalCode(requestDTO.getNationalCode()) != null){
            throw new CustomerException("duplicated_customer");
        }
        return initiateCustomer(requestDTO);
    }

    @Override
    public Customer findCustomerByNationalCode(String nationalCode){
        return customerRepo.findByNationalCode(nationalCode);
    }

    @Override
    public Customer findCustomerByCustomerNumber(String customerNumber) {
        return customerRepo.findByCustomerNumber(customerNumber);
    }

    private Customer initiateCustomer(RegisterCustomerRequestDTO requestDTO){
        Customer customer = new Customer();
        customer.setFirstName(requestDTO.getFirstName());
        customer.setLastName(requestDTO.getLastName());
        customer.setNationalCode(requestDTO.getNationalCode());
        customer.setMobileNumber(requestDTO.getMobileNumber());
        customer.setCustomerNumber(String.valueOf(IdGenerator.getInstance().getNextSequence()));

        customerRepo.atomSave(customer);
        return customer;
    }
}
