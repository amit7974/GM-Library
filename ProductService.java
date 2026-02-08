package com.example.GM.Publication.service;

import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    // ================= CREATE =================
    Product createProduct(
            ProductRequest request,
            MultipartFile demoPdf,
            MultipartFile thumbnail,
            MultipartFile adPoster,
            MultipartFile bookPdf
    );

    // ================= UPDATE =================
    Product updateProduct(
            Long productId,
            Product product,
            MultipartFile demoPdf,
            MultipartFile thumbnail,
            MultipartFile adPoster,
            MultipartFile bookPdf
    );

    // ================= READ =================
    Product getProductById(Long id);

    List<Product> getAllProducts();

    List<Product> getActiveProducts();

    // ================= DELETE =================
    void deleteProduct(Long id);
}

