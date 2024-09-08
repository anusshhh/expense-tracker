package com.budgetmaster.expensetracker.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
	private String firstName;
	private String lastName;
	@NotNull(message="Email is mandatory.")
	@NotEmpty(message="Email cannot be empty.")
	private String email;
	private String password;
}
