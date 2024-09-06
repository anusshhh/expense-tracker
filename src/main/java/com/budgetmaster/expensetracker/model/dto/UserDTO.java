package com.budgetmaster.expensetracker.model.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.budgetmaster.expensetracker.security.Role;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements UserDetails{
	String firstName;
	String lastName;
	String email;
	String userPassword;
    private Role role;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public String getPassword() {
		return userPassword;
	}
}
