package com.example.GM.Publication.controller.admin;


import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Book;
import com.example.GM.Publication.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/books")
@PreAuthorize("hasAnyRole('ADMIN','AUTHOR')")
public class AdminBookController {

    private final BookService bookService;

    public AdminBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    // ✅ TEST ENDPOINT
    @GetMapping("/test")
    public String test() {
        return "ADMIN / AUTHOR ACCESS OK";
    }

}
