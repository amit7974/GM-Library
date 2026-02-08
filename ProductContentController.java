package com.example.GM.Publication.controller.publicApi;


import com.example.GM.Publication.entity.Product;
import com.example.GM.Publication.repository.ProductRepository;
//import jakarta.annotation.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/products")
public class ProductContentController {

    private final ProductRepository productRepository;

    public ProductContentController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ Demo PDF (Download allowed)
    @GetMapping("/demo-pdf/{id}")
    public ResponseEntity<Resource> downloadDemoPdf(@PathVariable Long id)
            throws IOException {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Path path = Paths.get(product.getDemoPdfUrl());
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + path.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    // 🔐 Book PDF (View only)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/book-pdf/{id}")
    public ResponseEntity<Resource> viewBookPdf(@PathVariable Long id)
            throws IOException {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Path path = Paths.get(product.getBookPdfPath());
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
