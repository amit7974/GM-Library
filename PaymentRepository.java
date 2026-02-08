package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
