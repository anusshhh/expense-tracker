package com.budgetmaster.expensetracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;
import com.budgetmaster.expensetracker.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expense-tracker-api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
	private final ICategoryService categoryService;
	
	@PostMapping("/add-expense")
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
		return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
	}
	

}
