package com.budgetmaster.expensetracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.budgetmaster.expensetracker.model.dto.CategoryDTO;
import com.budgetmaster.expensetracker.service.ICategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/expense-tracker-api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
	private final ICategoryService categoryService;
	
	@PostMapping()
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
		return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
	}

	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	

}
