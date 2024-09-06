package com.budgetmaster.expensetracker.converter;

import org.springframework.stereotype.Component;

import com.budgetmaster.expensetracker.model.dto.ExpenseDTO;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;

@Component
public class ExpenseConverter {
	public ExpenseDTO toExpenseDTO(ExpenseEntity expenseEntity){
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setId(expenseEntity.getId());
        expenseDTO.setAmount(expenseEntity.getAmount());
        expenseDTO.setDate(expenseEntity.getDate());
        expenseDTO.setCategoryId(expenseEntity.getCategoryEntity().getId());
        expenseDTO.setUserId(expenseEntity.getUserEntity().getId());
        return expenseDTO;
    }

	public ExpenseEntity toExpenseEntity(ExpenseDTO expenseDTO){
		ExpenseEntity expenseEntity = new ExpenseEntity();
		expenseEntity.setId(expenseDTO.getId());
		expenseEntity.setAmount(expenseDTO.getAmount());
		expenseEntity.setDate(expenseDTO.getDate());
        return expenseEntity;
    }

}
