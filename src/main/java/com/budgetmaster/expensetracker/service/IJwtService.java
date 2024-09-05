package com.budgetmaster.expensetracker.service;

import javax.crypto.SecretKey;

public interface JwtService {
	
	SecretKey getSignInKey();
	
	String generateToken(String username);

    String extractUsername(String token);

    boolean isTokenValid(String token, String username);
}
