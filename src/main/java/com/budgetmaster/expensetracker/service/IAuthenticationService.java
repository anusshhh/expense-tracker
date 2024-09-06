package com.budgetmaster.expensetracker.service;

import com.budgetmaster.expensetracker.model.dto.RegisterRequest;
import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.model.dto.AuthenticationRequest;
import com.budgetmaster.expensetracker.model.dto.AuthenticationResponse;

public interface IAuthenticationService {
	public String register(RegisterRequest registerRequest);
	public AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
