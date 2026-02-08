package com.example.GM.Publication.controller;

import com.example.GM.Publication.entity.Description;
import com.example.GM.Publication.service.DescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/descriptions")
public class DescriptionController {

    private final DescriptionService descriptionService;

    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    // Fetch description when user selects a book
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Description> getDescriptionByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(descriptionService.getDescriptionByProductId(bookId));
    }
}
