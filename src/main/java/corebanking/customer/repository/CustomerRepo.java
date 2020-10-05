package corebanking.customer.repository;

import corebanking.common.repository.BasicRepo;
import corebanking.customer.model.Customer;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends BasicRepo<Customer> {
    Customer findByNationalCode(@Param("nationalCode") String nationalCode);

    Customer findByCustomerNumber(@Param("customerNumber") String customerNumber);
}
