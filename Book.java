package com.example.GM.Publication.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private int price; // total price

    private int coinLimitPercent; // ex: 10

    private int maxCoinUsage; // calculated

    private String demoPdfUrl;

    private String fullPdfUrl; // read only

    private String thumbnailUrl;

    private String adPosterUrl;

    private Long authorId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getMaxCoinUsage() {
        return maxCoinUsage;
    }

    public void setMaxCoinUsage(int maxCoinUsage) {
        this.maxCoinUsage = maxCoinUsage;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}

