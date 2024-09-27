package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.converter.CategoryConverter;
import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;
import com.budgetmaster.expensetracker.repository.CategoryRepository;
import com.budgetmaster.expensetracker.service.ICategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService{
	private final CategoryRepository categoryRepository;
	private final CategoryConverter categoryConverter;
	private final UserRepository userRepository;


	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();
		CategoryEntity categoryEntity = categoryConverter.toCategoryEntity(categoryDTO);
		categoryEntity.setUser(userEntity);
		categoryEntity = categoryRepository.save(categoryEntity);
		return categoryConverter.toCategoryDTO(categoryEntity);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();
		List<CategoryEntity> categoryEntityList = categoryRepository.findByUserIsNullOrUser_Id(userEntity.getId());
        return categoryEntityList.stream().map(categoryConverter::toCategoryDTO).toList();
	}


}
