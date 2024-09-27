package com.budgetmaster.expensetracker.service;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
	public CategoryDTO addCategory(CategoryDTO categoryDTO);

	public List<CategoryDTO> getAllCategories();
}
