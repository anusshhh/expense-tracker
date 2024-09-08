package com.budgetmaster.expensetracker.converter;

import org.springframework.stereotype.Component;

import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;

@Component
public class ExpenseConverter {
	public ExpenseDTO toExpenseDTO(ExpenseEntity expenseEntity){
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setId(expenseEntity.getId());
		expenseDTO.setTitle(expenseEntity.getTitle());
        expenseDTO.setAmount(expenseEntity.getAmount());
        expenseDTO.setDescription(expenseEntity.getDescription());
        expenseDTO.setDate(expenseEntity.getDate());
        expenseDTO.setCategoryId(expenseEntity.getCategoryEntity().getId());
        expenseDTO.setUserId(expenseEntity.getUserEntity().getId());
        return expenseDTO;
    }

	public ExpenseEntity toExpenseEntity(ExpenseDTO expenseDTO){
		ExpenseEntity expenseEntity = new ExpenseEntity();
		expenseEntity.setTitle(expenseDTO.getTitle());
		expenseEntity.setDescription(expenseDTO.getDescription());
		expenseEntity.setAmount(expenseDTO.getAmount());
		expenseEntity.setDate(expenseDTO.getDate());
        return expenseEntity;
    }

}
