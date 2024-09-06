package com.budgetmaster.expensetracker.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.converter.ExpenseConverter;
import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.repository.CategoryRepository;
import com.budgetmaster.expensetracker.repository.ExpenseRepository;
import com.budgetmaster.expensetracker.service.IExpenseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

	private final ExpenseRepository expenseRepository;
	private final CategoryRepository categoryRepository;

	private final ExpenseConverter expenseConverter;
	
	// probably will need to remove the id conversion in Converter classes.

	@Override
	public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
	    ExpenseEntity expenseEntity = expenseConverter.toExpenseEntity(expenseDTO);
	    expenseEntity = expenseRepository.save(expenseEntity);
	    return expenseConverter.toExpenseDTO(expenseEntity);
	}
	
	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

	@Override
	public ExpenseDTO editExpense(ExpenseDTO expenseDTO) {
		expenseRepository.save(expenseConverter.toExpenseEntity(expenseDTO));
		return expenseDTO;
	}

	@Override
	public List<ExpenseDTO> getExpenseByCategory(Long categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow();
		List<ExpenseEntity> expenseList = expenseRepository.findAllByCategory(categoryEntity);
		return expenseList.stream().map(expenseEntity -> expenseConverter.toExpenseDTO(expenseEntity)).collect(Collectors.toList());
	}
	
	
}
