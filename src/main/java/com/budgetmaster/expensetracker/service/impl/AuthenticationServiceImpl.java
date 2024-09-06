package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.converter.UserConverter;
import com.budgetmaster.expensetracker.model.dto.AuthenticationRequest;
import com.budgetmaster.expensetracker.model.dto.AuthenticationResponse;
import com.budgetmaster.expensetracker.model.dto.RegisterRequest;
import com.budgetmaster.expensetracker.model.dto.UserDTO;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.UserRepository;
import com.budgetmaster.expensetracker.security.JwtService;
import com.budgetmaster.expensetracker.security.Role;
import com.budgetmaster.expensetracker.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final JwtService jwtService;
    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterRequest registerRequest) {
        UserDTO userDTO = new UserDTO(registerRequest.getFirstName(), registerRequest.getLastName(),registerRequest.getEmail(), passwordEncoder.encode(registerRequest.getPassword()), Role.USER);
        UserEntity userEntity = userConverter.toUserEntity(userDTO);
        userRepository.save(userEntity);
        return "User registered successfully";
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        UserEntity userEntity = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        UserDTO userDto = userConverter.toUserDTO(userEntity);
        String token = jwtService.generateToken(userDto);
        return new AuthenticationResponse(token);
    }

}
