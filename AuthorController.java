package com.example.GM.Publication.controller.author;

import com.example.GM.Publication.entity.Author;
import com.example.GM.Publication.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
@PreAuthorize("hasRole('AUTHOR')")
public class AuthorController {


    @GetMapping("/dashboard")
    public String authorDashboard() {
        return "Author access only";
    }
}
