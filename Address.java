package com.example.GM.Publication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String phone;
    private String city;
    private String state;
    private String pincode;
    private String fullAddress;
}
