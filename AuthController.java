package com.example.GM.Publication.controller.auth;

import com.example.GM.Publication.dto.LoginRequest;
import com.example.GM.Publication.dto.LoginResponse;
import com.example.GM.Publication.dto.RegisterRequest;
import com.example.GM.Publication.entity.User;
import com.example.GM.Publication.repository.UserRepository;
import com.example.GM.Publication.service.AuthService;
import com.example.GM.Publication.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User Registered");
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
