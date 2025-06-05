package com.expense.tracker.service;

import com.expense.tracker.model.expense;
import com.expense.tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // === Basic CRUD ===

    public List<expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public expense addExpense(expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public expense updateExpense(Long id, expense newExpense) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setTitle(newExpense.getTitle());
            expense.setCategory(newExpense.getCategory());
            expense.setAmount(newExpense.getAmount());
            expense.setDate(newExpense.getDate());
            return expenseRepository.save(expense);
        }).orElse(null);
    }

    // === Monthly Category Totals ===

    public Map<String, Double> getMonthlyCategoryTotals(int month, int year) {
        List<expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .filter(e -> {
                    LocalDate date = LocalDate.parse(e.getDate());
                    return date.getMonthValue() == month && date.getYear() == year;
                })
                .collect(Collectors.groupingBy(
                        expense::getCategory,
                        Collectors.summingDouble(expense::getAmount)
                ));
    }

    // === Weekly Category Totals ===

    public Map<Integer, Map<String, Double>> getWeeklyCategoryTotals(int month, int year) {
        List<expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .filter(e -> {
                    LocalDate date = LocalDate.parse(e.getDate());
                    return date.getMonthValue() == month && date.getYear() == year;
                })
                .collect(Collectors.groupingBy(
                        e -> (LocalDate.parse(e.getDate()).getDayOfMonth() - 1) / 7 + 1,
                        Collectors.groupingBy(
                                expense::getCategory,
                                Collectors.summingDouble(expense::getAmount)
                        )
                ));
    }
}
