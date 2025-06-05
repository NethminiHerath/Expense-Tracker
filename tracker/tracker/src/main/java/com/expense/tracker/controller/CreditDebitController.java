package com.expense.tracker.controller;

import com.expense.tracker.model.CreditDebit;
import com.expense.tracker.service.CreditDebitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditdebit")
public class CreditDebitController {

    private final CreditDebitService service;

    public CreditDebitController(CreditDebitService service) {
        this.service = service;
    }

    @PostMapping
    public CreditDebit add(@RequestBody CreditDebit entry) {
        return service.addEntry(entry);
    }

    @GetMapping
    public List<CreditDebit> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CreditDebit getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<CreditDebit> getByMonthYear(@PathVariable int month, @PathVariable int year) {
        return service.getByMonthYear(month, year);
    }

    @PutMapping("/{id}")
    public CreditDebit update(@PathVariable Long id, @RequestBody CreditDebit entry) {
        return service.update(id, entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
