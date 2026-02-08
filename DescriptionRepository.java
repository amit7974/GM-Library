package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description,Long> {

    Optional<Description> findByProductId(Long productId);
}
