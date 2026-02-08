package com.example.GM.Publication.service;


import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Product;
import com.example.GM.Publication.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private static final String UPLOAD_DIR = "uploads/products/";

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ================= CREATE =================
    @Override
    public Product createProduct(
            ProductRequest request,
            MultipartFile demoPdf,
            MultipartFile thumbnail,
            MultipartFile adPoster,
            MultipartFile bookPdf
    ) {

        Product product = new Product();

        product.setBookName(request.getTitle());
        product.setPdfPrice(request.getPrice());
        product.setCoinLimitPercent(request.getCoinLimitPercent());
        product.setActive(true);

        int maxCoins = (request.getPrice() * request.getCoinLimitPercent()) / 100;
        product.setMaxCoinUsage(maxCoins);

        product.setDemoPdfUrl(saveFile(demoPdf));
        product.setThumbnailUrl(saveFile(thumbnail));
        product.setAdPosterUrl(saveFile(adPoster));
        product.setBookPdfPath(saveFile(bookPdf));

        return productRepository.save(product);
    }

    // ================= UPDATE =================
    @Override
    public Product updateProduct(
            Long productId,
            Product updated,
            MultipartFile demoPdf,
            MultipartFile thumbnail,
            MultipartFile adPoster,
            MultipartFile bookPdf
    ) {

        Product existing = getProductById(productId);

        existing.setBookName(updated.getBookName());
        existing.setPdfPrice(updated.getPdfPrice());
        existing.setCoinLimitPercent(updated.getCoinLimitPercent());

        int maxCoins = (int)(updated.getPdfPrice() * updated.getCoinLimitPercent()) / 100;
        existing.setMaxCoinUsage(maxCoins);

        if (demoPdf != null && !demoPdf.isEmpty()) {
            existing.setDemoPdfUrl(saveFile(demoPdf));
        }
        if (thumbnail != null && !thumbnail.isEmpty()) {
            existing.setThumbnailUrl(saveFile(thumbnail));
        }
        if (adPoster != null && !adPoster.isEmpty()) {
            existing.setAdPosterUrl(saveFile(adPoster));
        }
        if (bookPdf != null && !bookPdf.isEmpty()) {
            existing.setBookPdfPath(saveFile(bookPdf));
        }

        return productRepository.save(existing);
    }

    // ================= READ =================
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getActiveProducts() {
        return productRepository.findByActiveTrue();
    }

    // ================= DELETE =================
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // ================= FILE UPLOAD =================
    private String saveFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) return null;

            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            return path.toString();

        } catch (IOException e) {
            throw new RuntimeException("File upload failed", e);
        }
    }
}
