package com.example.GM.Publication.service;

import com.example.GM.Publication.dto.LoginRequest;
import com.example.GM.Publication.dto.LoginResponse;
import com.example.GM.Publication.dto.RegisterRequest;
import com.example.GM.Publication.entity.User;
import com.example.GM.Publication.entity.enums.Role;
import com.example.GM.Publication.repository.UserRepository;
import com.example.GM.Publication.util.JWTUtil;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JWTUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 🟢 Set roles
        Set<Role> roleSet = new HashSet<>();

        if (request.getRoles() == null || request.getRoles().isEmpty()) {
            // Default role
            roleSet.add(Role.USER);
            System.out.println("No roles provided. Defaulting to USER");
        } else {
            for (String roleStr : request.getRoles()) {
                try {
                    Role role = Role.valueOf(roleStr.toUpperCase());
                    roleSet.add(role);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid role: " + roleStr);
                }
            }
        }

        user.setRoles(roleSet);

        userRepository.save(user);

        System.out.println("User registered successfully: " + user.getEmail());
        System.out.println("Assigned Roles: " + user.getRoles());
    }


    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        List<String> roles = user.getRoles().stream()
                .map(Enum::name)
                .toList();

        String token = jwtUtil.generateToken(user.getEmail(), roles);

        return new LoginResponse(token, roles.get(0));

    }
}

