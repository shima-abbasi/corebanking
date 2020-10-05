package corebanking.deposit.model;

import corebanking.common.model.Basic;
import corebanking.customer.model.Customer;

import javax.persistence.*;

@Entity
@Table(name = "T_DEPOSIT")
public class Deposit extends Basic {
    private Customer customer;
    private String depositNumber;
    private long balance;

    public Deposit(Customer customer, String depositNumber, long balance) {
        this.customer = customer;
        this.depositNumber = depositNumber;
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn(name = "FK_CUSTOMER")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "DEPOSIT_NUMBER")
    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    @Column(name = "C_BALANCE")
    @Version
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
