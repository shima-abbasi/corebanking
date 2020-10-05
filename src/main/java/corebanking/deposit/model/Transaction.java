package corebanking.deposit.model;

import corebanking.common.model.Basic;
import corebanking.customer.model.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_TRANSACTION")
public class Transaction extends Basic {
    private Date date;
    private Customer customer;
    private String description;

    public Transaction(Date date, Customer customer, String description) {
        this.date = date;
        this.customer = customer;
        this.description = description;
    }

    @Column(name = "C_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CUSTOMER")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "C_DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
