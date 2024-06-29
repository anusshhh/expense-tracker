package com.budgetmaster.expensetracker.model.entity;

import com.budgetmaster.expensetracker.security.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING)
	Role role;
}
