package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(Long authorId);

    // Get books within a price range
    List<Book> findByPriceBetween(int minPrice, int maxPrice);

    // Search by title (case-insensitive)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Get books with coin limit enabled
    List<Book> findByCoinLimitPercentGreaterThan(int percent);


}
