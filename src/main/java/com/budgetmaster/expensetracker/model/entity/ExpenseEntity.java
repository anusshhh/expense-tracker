package com.budgetmaster.expensetracker.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense_table")
public class ExpenseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private Double amount;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
	

}
