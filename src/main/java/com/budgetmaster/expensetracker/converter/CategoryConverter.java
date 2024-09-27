package com.budgetmaster.expensetracker.converter;

import org.springframework.stereotype.Component;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;
import com.budgetmaster.expensetracker.model.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(categoryDTO.getId());
		categoryEntity.setName(categoryDTO.getName());
		return categoryEntity;
	}
	
	public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setName(categoryEntity.getName());
		categoryDTO.setUserId(categoryEntity.getUser().getId());
		return categoryDTO;
	}

}
