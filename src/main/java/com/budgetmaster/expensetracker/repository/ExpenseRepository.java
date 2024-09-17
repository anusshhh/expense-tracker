package com.budgetmaster.expensetracker.repository;

import java.time.LocalDate;
import java.util.List;

import com.budgetmaster.expensetracker.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
	public List<ExpenseEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);

	public List<ExpenseEntity> findByDateBetweenAndUserEntity(LocalDate startDate, LocalDate endDate, UserEntity userEntity);
}
