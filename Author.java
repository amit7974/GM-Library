package com.example.GM.Publication.entity;

import com.example.GM.Publication.entity.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String state;

    private String district;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobile;

    private String photo; // store URL or file path

    @Column(nullable = false)
    private String password;

    @Transient
    private String confirmPassword; // UI only, not stored in DB

    @Column(nullable = false)
    private boolean emailVerified;

    private String otp; // OTP for email verification

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}