package com.expense.tracker.service;

import com.expense.tracker.model.income;
import com.expense.tracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public income addIncome(income income) {
        return incomeRepository.save(income);
    }

    public List<income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public Optional<income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public List<income> getIncomeByMonthYear(int month, int year) {
        return incomeRepository.findByMonthAndYear(month, year);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    public income updateIncome(Long id, income updated) {
        return incomeRepository.findById(id).map(income -> {
            income.setAmount(updated.getAmount());
            income.setMonth(updated.getMonth());
            income.setYear(updated.getYear());
            income.setSource(updated.getSource());
            return incomeRepository.save(income);
        }).orElseThrow(() -> new RuntimeException("Income not found"));
    }
}
