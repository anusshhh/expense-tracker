package com.budgetmaster.expensetracker.repository;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
    public List<IncomeEntity> findByUserEntity(UserEntity userEntity);
    public List<IncomeEntity> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
