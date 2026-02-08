package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
