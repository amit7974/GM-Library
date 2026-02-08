package com.example.GM.Publication.controller.admin;


import com.example.GM.Publication.entity.Category;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/category")
@PreAuthorize("hasRole('ADMIN')")
public class CategoryController {

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return category;
    }
}
