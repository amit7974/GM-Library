package com.example.GM.Publication.controller.admin;


import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Product;
import com.example.GM.Publication.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin/products")
@PreAuthorize("hasRole('ADMIN')")
public class AdminProductController {

    private final ProductService productService;

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<Product> createProduct(
            @RequestPart("product") ProductRequest product,
            @RequestPart(value = "demoPdf", required = false) MultipartFile demoPdf,
            @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail,
            @RequestPart(value = "adPoster", required = false) MultipartFile adPoster,
            @RequestPart(value = "bookPdf", required = false) MultipartFile bookPdf
    ) {
        return ResponseEntity.ok(
                productService.createProduct(product, demoPdf, thumbnail, adPoster, bookPdf)
        );
    }

    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestPart("product") Product product,
            @RequestPart(value = "demoPdf", required = false) MultipartFile demoPdf,
            @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail,
            @RequestPart(value = "adPoster", required = false) MultipartFile adPoster,
            @RequestPart(value = "bookPdf", required = false) MultipartFile bookPdf
    ) {
        return ResponseEntity.ok(
                productService.updateProduct(id, product, demoPdf, thumbnail, adPoster, bookPdf)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}