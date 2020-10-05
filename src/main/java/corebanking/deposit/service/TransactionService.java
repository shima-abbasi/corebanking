package corebanking.deposit.service;

import corebanking.deposit.model.Transaction;
import corebanking.customer.model.Customer;

public interface TransactionService {
    Transaction initiateTransation(String description, Customer customer);
}
