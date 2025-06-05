

package com.expense.tracker.model;

import jakarta.persistence.*;

@Entity
public class income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int month;     // 1 to 12
    private int year;
    private double amount;
    private String source; // Optional description like "Salary", "Freelance", etc.

    public income() {}

    public income(int month, int year, double amount, String source) {
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.source = source;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}

