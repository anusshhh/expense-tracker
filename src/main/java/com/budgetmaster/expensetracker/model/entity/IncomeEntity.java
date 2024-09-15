package com.budgetmaster.expensetracker.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Data
@Table(name = "income_table")
public class IncomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String source;
	private Double amount;
	private String description;
	private LocalDateTime date;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
}
