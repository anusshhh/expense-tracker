package com.budgetmaster.expensetracker.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.converter.ExpenseConverter;
import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.CategoryRepository;
import com.budgetmaster.expensetracker.repository.ExpenseRepository;
import com.budgetmaster.expensetracker.repository.UserRepository;
import com.budgetmaster.expensetracker.service.IExpenseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

	private final ExpenseRepository expenseRepository;
	private final CategoryRepository categoryRepository;
	private final ExpenseConverter expenseConverter;
	private final UserRepository userRepository;

	@Override
	public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
		ExpenseEntity expenseEntity = expenseConverter.toExpenseEntity(expenseDTO);
		CategoryEntity categoryEntity = categoryRepository.findById(expenseDTO.getCategoryId()).orElseThrow();
		UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();
		expenseEntity.setCategoryEntity(categoryEntity);	
		expenseEntity.setUserEntity(userEntity);
		expenseEntity = expenseRepository.save(expenseEntity);
		return expenseConverter.toExpenseDTO(expenseEntity);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

	@Override
	public ExpenseDTO editExpense(Long expenseId, ExpenseDTO expenseDTO) {
		ExpenseEntity existingExpense = expenseRepository.findById(expenseId).orElseThrow();

		ExpenseEntity updatedExpense = expenseConverter.toExpenseEntity(expenseDTO);
		updatedExpense.setId(existingExpense.getId()); 

		CategoryEntity categoryEntity = categoryRepository.findById(expenseDTO.getCategoryId()).orElseThrow();

		updatedExpense.setCategoryEntity(categoryEntity);
		expenseRepository.save(updatedExpense);

		return expenseConverter.toExpenseDTO(updatedExpense);
	}

	@Override
	public List<ExpenseDTO> getExpenseByCategory(Long categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow();
		List<ExpenseEntity> expenseList = expenseRepository.findAllByCategoryEntity(categoryEntity);
		return expenseList.stream().map(expenseEntity -> expenseConverter.toExpenseDTO(expenseEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<ExpenseDTO> getAllExpenses() {
		List<ExpenseEntity> expenseList = expenseRepository.findAll();
		return expenseList.stream().map(expenseEntity -> expenseConverter.toExpenseDTO(expenseEntity))
				.collect(Collectors.toList());
	}
}
