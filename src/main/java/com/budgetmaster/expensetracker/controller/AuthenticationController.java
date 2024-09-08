package com.budgetmaster.expensetracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetmaster.expensetracker.model.dto.AuthenticationRequest;
import com.budgetmaster.expensetracker.model.dto.AuthenticationResponse;
import com.budgetmaster.expensetracker.model.dto.RegisterRequest;
import com.budgetmaster.expensetracker.service.IAuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expense-tracker-api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final IAuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
		AuthenticationResponse response = authService.login(authenticationRequest);
        return ResponseEntity.ok(response);
	}

}
