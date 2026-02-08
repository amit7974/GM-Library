package com.example.GM.Publication.service;

import com.example.GM.Publication.entity.Description;
import com.example.GM.Publication.entity.Product;
import com.example.GM.Publication.repository.DescriptionRepository;
import com.example.GM.Publication.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DescriptionServiceImpl implements DescriptionService{

    private final DescriptionRepository descriptionRepository;
    private final ProductRepository productRepository;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository,
                                  ProductRepository productRepository) {
        this.descriptionRepository = descriptionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Description getDescriptionByProductId(Long productId) {
        return descriptionRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Description not found for book"));
    }

    @Override
    public Description saveDescription(Long productId, String descriptionText) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Description description = new Description(product, descriptionText);

        return descriptionRepository.save(description);
    }
}
