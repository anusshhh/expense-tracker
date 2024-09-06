package com.budgetmaster.expensetracker.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Category")
public class CategoryEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String name;
}
