package com.budgetmaster.expensetracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/by-category")
	public ResponseEntity<List<ExpenseDTO>> getExpensesByList(@RequestParam Long categoryId) {
		return ResponseEntity.ok(expenseService.getExpenseByCategory(categoryId));
	}

}
