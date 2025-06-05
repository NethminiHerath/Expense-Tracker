package com.expense.tracker.repository;

import com.expense.tracker.model.CreditDebit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditDebitRepository extends JpaRepository<CreditDebit, Long> {
    List<CreditDebit> findByMonthAndYear(int month, int year);
}
