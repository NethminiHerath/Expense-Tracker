package com.expense.tracker.controller;

import com.expense.tracker.model.income;
import com.expense.tracker.service.IncomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public income addIncome(@RequestBody income income) {
        return incomeService.addIncome(income);
    }

    @GetMapping
    public List<income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public income getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id).orElse(null);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<income> getByMonthYear(@PathVariable int month, @PathVariable int year) {
        return incomeService.getIncomeByMonthYear(month, year);
    }

    @PutMapping("/{id}")
    public income updateIncome(@PathVariable Long id, @RequestBody income income) {
        return incomeService.updateIncome(id, income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
