package com.budgetmaster.expensetracker.service.impl;

import org.springframework.stereotype.Service;

import com.budgetmaster.expensetracker.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService{

	@Override
	public String generateToken(String username) {
		return null;
	}

	@Override
	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValid(String token, String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
