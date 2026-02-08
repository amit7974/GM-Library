package com.example.GM.Publication.controller;

import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Book;
import com.example.GM.Publication.service.BookService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ================= CREATE BOOK =================
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('AUTHOR')")
    public ResponseEntity<Book> createBook(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    // ================= DEMO PDF (Download allowed) =================
    @GetMapping("/demo-pdf/{bookId}")
    public ResponseEntity<Resource> downloadDemoPdf(@PathVariable Long bookId) {
        Resource pdf = bookService.getDemoPdf(bookId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=demo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    // ================= FULL PDF (Read only) =================
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/full-pdf/{bookId}")
    public ResponseEntity<Resource> viewFullPdf(@PathVariable Long bookId) {
        Resource pdf = bookService.getFullPdf(bookId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }


}
