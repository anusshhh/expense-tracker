package com.budgetmaster.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
	public List<ExpenseEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);

}
