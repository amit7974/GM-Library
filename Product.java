package com.example.GM.Publication.entity;

//package com.example.GM_Publication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. Book Name
    @Column(nullable = false)
    private String bookName;

    // 2. Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // 3. Sub Category
    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    // 4. MRP for PDF reading
    private double pdfMrp;

    // 5. Price for PDF reading
    private double pdfPrice;

    // 6. MRP for HardCopy notes
    private double hardcopyMrp;

    // 7. Price for HardCopy notes
    private double hardcopyPrice;

    // 8. Select Coupons (comma separated coupon codes)
    private String coupons;

    // 9. Coin limit
    // Admin input (10, 20, etc.)
    private int coinLimitPercent;

    // System calculated (Price * %)
    private int maxCoinUsage;


    // 10. Description
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Description description;


    // 11. Demo Content
    @Column(length = 2000)
    private String demoContent;

    // 12. Demo PDF (downloadable)
    private String demoPdfUrl;

    // 13. Thumbnail
    private String thumbnailUrl;

    // 14. Ad Poster
    private String adPosterUrl;

    // 15. Main Book PDF (read-only)
    private String bookPdfPath;

    // 16. Author
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    // Status
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public double getPdfMrp() {
        return pdfMrp;
    }

    public void setPdfMrp(double pdfMrp) {
        this.pdfMrp = pdfMrp;
    }

    public double getPdfPrice() {
        return pdfPrice;
    }

    public void setPdfPrice(double pdfPrice) {
        this.pdfPrice = pdfPrice;
    }

    public double getHardcopyMrp() {
        return hardcopyMrp;
    }

    public void setHardcopyMrp(double hardcopyMrp) {
        this.hardcopyMrp = hardcopyMrp;
    }

    public double getHardcopyPrice() {
        return hardcopyPrice;
    }

    public void setHardcopyPrice(double hardcopyPrice) {
        this.hardcopyPrice = hardcopyPrice;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
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

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getDemoContent() {
        return demoContent;
    }

    public void setDemoContent(String demoContent) {
        this.demoContent = demoContent;
    }

    public String getDemoPdfUrl() {
        return demoPdfUrl;
    }

    public void setDemoPdfUrl(String demoPdfUrl) {
        this.demoPdfUrl = demoPdfUrl;
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

    public String getBookPdfPath() {
        return bookPdfPath;
    }

    public void setBookPdfPath(String bookPdfPath) {
        this.bookPdfPath = bookPdfPath;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
