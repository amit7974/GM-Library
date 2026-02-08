package com.example.GM.Publication.repository;


import com.example.GM.Publication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByEmail(String email);

     boolean existsByEmail(String email);
}
