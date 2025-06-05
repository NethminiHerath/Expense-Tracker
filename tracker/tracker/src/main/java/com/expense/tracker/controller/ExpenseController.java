package com.expense.tracker.controller;

import com.expense.tracker.model.expense;
import com.expense.tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // === Basic CRUD ===

    @GetMapping
    public List<expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping
    public expense addExpense(@RequestBody expense expense) {
        return expenseService.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @PutMapping("/{id}")
    public expense updateExpense(@PathVariable Long id, @RequestBody expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    // === Monthly Category-Wise Totals ===

    @GetMapping("/monthly/category")
    public Map<String, Double> getMonthlyCategoryTotals(@RequestParam int month, @RequestParam int year) {
        return expenseService.getMonthlyCategoryTotals(month, year);
    }

    // === Weekly Category-Wise Totals ===

    @GetMapping("/weekly/category")
    public Map<Integer, Map<String, Double>> getWeeklyCategoryTotals(@RequestParam int month, @RequestParam int year) {
        return expenseService.getWeeklyCategoryTotals(month, year);
    }
}
