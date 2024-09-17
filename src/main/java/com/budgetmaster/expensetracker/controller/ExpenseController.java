package com.budgetmaster.expensetracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.service.IExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expense-tracker-api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {
	private final IExpenseService expenseService;

	@PostMapping
	public ResponseEntity<ExpenseDTO> addExpense(@RequestBody ExpenseDTO expenseDTO) {
		return ResponseEntity.ok(expenseService.addExpense(expenseDTO));
	}

	@GetMapping
	public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExpenseDTO> editExpense(@PathVariable Long id, @RequestBody ExpenseDTO expenseDTO) {
		return ResponseEntity.ok(expenseService.editExpense(id,expenseDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/by-category")
	public ResponseEntity<List<ExpenseDTO>> getExpensesByList(@RequestParam Long categoryId) {
		return ResponseEntity.ok(expenseService.getExpenseByCategory(categoryId));
	}

}
