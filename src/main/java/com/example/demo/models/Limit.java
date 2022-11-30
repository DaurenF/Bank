package com.example.demo.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Limits")
public class Limit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "value")
    private double value;
    @Column(name = "limit_date_time")
    private Date limit_date_time;
    @Column(name = "limit_currency_shortname")
    private String limit_currency_shortname;
    @Column(name = "remaining_usd")
    private double remaining_usd;

    @Column(name = "expense_category")
    private String category;


    public Limit() {
    }

    public Limit(double value, Date limit_date_time, String limit_currency_shortname, double remaining_usd, String category) {
        this.value = value;
        this.limit_date_time = limit_date_time;
        this.limit_currency_shortname = limit_currency_shortname;
        this.remaining_usd = remaining_usd;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getLimit_date_time() {
        return limit_date_time;
    }

    public void setLimit_date_time(Date limit_date_time) {
        this.limit_date_time = limit_date_time;
    }

    public String getLimit_currency_shortname() {
        return limit_currency_shortname;
    }

    public void setLimit_currency_shortname(String limit_currency_shortname) {
        this.limit_currency_shortname = limit_currency_shortname;
    }

    public double getRemaining_usd() {
        return remaining_usd;
    }

    public void setRemaining_usd(double remaining_usd) {
        this.remaining_usd = remaining_usd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
