package com.budgetmaster.expensetracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class UserEntity {
	@Id
	@GeneratedValue
	long id;
	String firstName;
	String lastName;
	String email;
	String password;
}
