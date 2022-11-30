package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sum")
    @NotEmpty(message = "Sum of transaction must not be null")
    private double sum;
    @Column(name = "account_from")
    @NotEmpty(message = "Account id of transaction must not be null")
    private int account_from;
    @Column(name = "account_to")
    @NotEmpty(message = "Account address of transaction must not be null")
    private int account_to;
    @Column(name = "currency_shortname")
    @NotEmpty(message = "Currency of transaction must not be null")
    private String currency_shortname;
    @Column(name = "expense_category")
    @NotEmpty(message = "Category of transaction must not be null")
    private String expense_category;
    @Column(name = "date_of_transaction")
    @NotEmpty(message = "Date of transaction must not be null")
    private Date date_of_transaction;
    @Column(name = "limit_exceeded")
    private Boolean exceeded;

    public Boolean getExceeded() {
        return exceeded;
    }

    public void setExceeded(Boolean exceeded) {
        this.exceeded = exceeded;
    }

    @ManyToOne
    @JoinColumn(name = "limit_id", referencedColumnName = "id")
    private Limit limit;

    public Transaction() {
    }

    public Transaction(double sum, int account_from, int account_to, String currency_shortname,
                       String expense_category, Date date_of_transaction) {
        this.sum = sum;
        this.account_from = account_from;
        this.account_to = account_to;
        this.currency_shortname = currency_shortname;
        this.expense_category = expense_category;
        this.date_of_transaction = date_of_transaction;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getAccount_from() {
        return account_from;
    }

    public void setAccount_from(int account_from) {
        this.account_from = account_from;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public String getCurrency_shortname() {
        return currency_shortname;
    }

    public void setCurrency_shortname(String currency_shortname) {
        this.currency_shortname = currency_shortname;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }

    public Date getDate_of_transaction() {
        return date_of_transaction;
    }

    public void setDate_of_transaction(Date date_of_transaction) {
        this.date_of_transaction = date_of_transaction;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }


}
