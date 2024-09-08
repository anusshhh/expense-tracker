package com.budgetmaster.expensetracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.service.IExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expense-tracker-api/v1/expense")
@RequiredArgsConstructor
public class ExpenseController {
	private final IExpenseService expenseService;
	
	@PostMapping("/add-expense")
	public ResponseEntity<ExpenseDTO> addExpense(@RequestBody ExpenseDTO expenseDTO){
		return ResponseEntity.ok(expenseService.addExpense(expenseDTO));
	}
	
	@GetMapping("/get-expenses")
	public ResponseEntity<List<ExpenseDTO>> getAllExpenses(){
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

}
