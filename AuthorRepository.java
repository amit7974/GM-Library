package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Author;

public interface AuthorRepository {

    Author findByEmail(String email);
}
