package com.budgetmaster.expensetracker.repository;

import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> findByUserIsNullOrUser_Id(Long userId);
}
