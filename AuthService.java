package com.example.GM.Publication.service;

import com.example.GM.Publication.dto.LoginRequest;
import com.example.GM.Publication.dto.LoginResponse;
import com.example.GM.Publication.dto.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
