package com.example.GM.Publication.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="description")
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One description belongs to one book
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    public Description() {
    }

    public Description(Product product, String description) {
        this.product = product;
        this.description = description;
    }

    // ---------- Getters & Setters ----------
    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}