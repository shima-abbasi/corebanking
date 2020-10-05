package corebanking.deposit.repository;

import corebanking.common.repository.BasicRepo;
import corebanking.deposit.model.Deposit;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepo extends BasicRepo<Deposit> {
    Deposit findByDepositNumber(@Param("depositNumber") String depositNumber);
}
