package com.todoapp.service;

import com.todoapp.dto.JwtAuthenticationResponse;
import com.todoapp.dto.LoginRequest;
import com.todoapp.dto.SignUpRequest;

public interface AuthService {
    JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest);
    JwtAuthenticationResponse registerUser(SignUpRequest signUpRequest);
} 