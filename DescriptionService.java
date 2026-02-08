package com.example.GM.Publication.service;

import com.example.GM.Publication.entity.Description;

public interface DescriptionService {

    Description getDescriptionByProductId(Long productId);

    Description saveDescription(Long productId, String descriptionText);
}
