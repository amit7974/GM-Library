package com.example.GM.Publication.service;

import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Book;
import org.springframework.core.io.Resource;

public interface BookService {

    // Create book (Admin / Author)
    Book createBook(ProductRequest request);

    // Demo PDF (public download)
    Resource getDemoPdf(Long bookId);

    // Book PDF (USER only – read)
    Resource getFullPdf(Long bookId);

    }



