package com.expense.tracker.repository;

import com.expense.tracker.model.income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncomeRepository extends JpaRepository<income, Long> {
    List<income> findByMonthAndYear(int month, int year);
}
