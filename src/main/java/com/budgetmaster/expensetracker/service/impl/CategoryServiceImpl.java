package com.budgetmaster.expensetracker.service.impl;

import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;
import com.budgetmaster.expensetracker.repository.CategoryRepository;
import com.budgetmaster.expensetracker.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService{
	private final CategoryRepository categoryRepository;

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		return null;
	}
	
	
}
