package com.budgetmaster.expensetracker.controller;

import com.budgetmaster.expensetracker.model.dto.IncomeDTO;
import com.budgetmaster.expensetracker.service.IIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense-tracker-api/v1/income")
@RequiredArgsConstructor
public class IncomeController {
    private IIncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> addExpense(@RequestBody IncomeDTO incomeDTO) {
        return ResponseEntity.ok(incomeService.addIncome(incomeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDTO> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        IncomeDTO updatedIncome = incomeService.updateIncome(id, incomeDTO);
        return ResponseEntity.ok(updatedIncome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getAllIncome() {
        return ResponseEntity.ok(incomeService.getAllIncome());
    }


}
