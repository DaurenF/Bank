package com.example.demo.models;


import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Currency")
public class Currency {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "value")
    private double value;
    @Column(name = "date_of_value")
    private Date date_of_value;

    public Currency() {
    }

    public Currency(double value, Date date_of_value) {
        this.value = value;
        this.date_of_value = date_of_value;
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

    public Date getDate_of_value() {
        return date_of_value;
    }

    public void setDate_of_value(Date date_of_value) {
        this.date_of_value = date_of_value;
    }
}
