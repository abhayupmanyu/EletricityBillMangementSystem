package com.demo;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Bill {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private double amount;
    private Date billDate;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable=false)
    private Customer customer;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
