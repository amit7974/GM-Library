package com.example.GM.Publication.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class ProductRequest {

    private String title;
    private String description;
    private int price;
    private int coinLimitPercent;
    private Long authorId;

    private String demoPdfUrl;
    private String fullPdfUrl;
    private String thumbnailUrl;
    private String adPosterUrl;

    // ===== Getters & Setters =====

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCoinLimitPercent() {
        return coinLimitPercent;
    }

    public void setCoinLimitPercent(int coinLimitPercent) {
        this.coinLimitPercent = coinLimitPercent;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getDemoPdfUrl() {
        return demoPdfUrl;
    }

    public void setDemoPdfUrl(String demoPdfUrl) {
        this.demoPdfUrl = demoPdfUrl;
    }

    public String getFullPdfUrl() {
        return fullPdfUrl;
    }

    public void setFullPdfUrl(String fullPdfUrl) {
        this.fullPdfUrl = fullPdfUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAdPosterUrl() {
        return adPosterUrl;
    }

    public void setAdPosterUrl(String adPosterUrl) {
        this.adPosterUrl = adPosterUrl;
    }


}
