package com.budgetmaster.expensetracker.service;

import java.util.List;

import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;

public interface IExpenseService {

	public ExpenseDTO addExpense(ExpenseDTO expenseDTO);

	public void deleteExpense(Long id);
	
	public ExpenseDTO editExpense(ExpenseDTO expenseDTO);
	
	public List<ExpenseDTO> getExpenseByCategory(Long categoryId );

}
