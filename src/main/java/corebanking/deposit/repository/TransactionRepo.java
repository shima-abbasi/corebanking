package corebanking.deposit.repository;

import corebanking.common.repository.BasicRepo;
import corebanking.deposit.model.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends BasicRepo<Transaction> {
}
