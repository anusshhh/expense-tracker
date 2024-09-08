package com.budgetmaster.expensetracker.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthenticationRequest{
	@NotBlank(message="Email is mandatory.")
	@NotEmpty(message="Email cannot be empty.")
	private String email;
	private String password;
}
