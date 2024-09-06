package com.budgetmaster.expensetracker.model.dto;

import java.time.LocalDate;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {
	private long id;
	private Double amount;
	private LocalDate date;
	private String description;
	private Long categoryId;
	private Long userId;
}