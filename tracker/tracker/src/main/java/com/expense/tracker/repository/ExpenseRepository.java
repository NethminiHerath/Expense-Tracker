package com.expense.tracker.repository;

import com.expense.tracker.model.expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<expense, Long> {
    // You can later define custom queries here if needed
}
