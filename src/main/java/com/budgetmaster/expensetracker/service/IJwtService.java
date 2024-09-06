package com.budgetmaster.expensetracker.service;

import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;

public interface IJwtService {
	
	SecretKey getSignInKey();
	
	String generateToken(UserDetails userDetails);

    public String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
