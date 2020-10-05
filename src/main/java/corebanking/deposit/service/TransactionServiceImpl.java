package corebanking.deposit.service;

import corebanking.deposit.model.Transaction;
import corebanking.deposit.repository.TransactionRepo;
import corebanking.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction initiateTransation(String description, Customer customer){
        Transaction transaction = new Transaction(new Date(), customer, description);
        transactionRepo.atomSave(transaction);
        return transaction;
    }
}
