package com.expense.tracker.model;

import jakarta.persistence.*;

@Entity
public class CreditDebit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int month;
    private int year;

    private String description;  // e.g., "Loan repayment", "Subscription due", etc.
    private double amount;

    @Enumerated(EnumType.STRING)
    private Type type;  // CREDIT or DEBIT

    public enum Type {
        CREDIT, DEBIT
    }

    public CreditDebit() {}

    public CreditDebit(int month, int year, String description, double amount, Type type) {
        this.month = month;
        this.year = year;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
}
