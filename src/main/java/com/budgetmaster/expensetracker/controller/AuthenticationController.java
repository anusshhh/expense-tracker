package com.budgetmaster.expensetracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetmaster.expensetracker.entity.UserEntity;

@RestController
@RequestMapping("/expense-tracker-api/v1/auth")
public class AuthenticationController {
	
	
	@PostMapping("/register")
	public UserEntity register() {
		return null;
	}

}
