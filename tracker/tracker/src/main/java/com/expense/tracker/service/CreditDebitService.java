package com.expense.tracker.service;

import com.expense.tracker.model.CreditDebit;
import com.expense.tracker.repository.CreditDebitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditDebitService {

    private final CreditDebitRepository repository;

    public CreditDebitService(CreditDebitRepository repository) {
        this.repository = repository;
    }

    public CreditDebit addEntry(CreditDebit entry) {
        return repository.save(entry);
    }

    public List<CreditDebit> getAll() {
        return repository.findAll();
    }

    public Optional<CreditDebit> getById(Long id) {
        return repository.findById(id);
    }

    public List<CreditDebit> getByMonthYear(int month, int year) {
        return repository.findByMonthAndYear(month, year);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreditDebit update(Long id, CreditDebit updated) {
        return repository.findById(id).map(entry -> {
            entry.setAmount(updated.getAmount());
            entry.setDescription(updated.getDescription());
            entry.setMonth(updated.getMonth());
            entry.setYear(updated.getYear());
            entry.setType(updated.getType());
            return repository.save(entry);
        }).orElseThrow(() -> new RuntimeException("Entry not found"));
    }
}
