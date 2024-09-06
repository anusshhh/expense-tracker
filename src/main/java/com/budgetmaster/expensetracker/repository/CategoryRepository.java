package com.budgetmaster.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
