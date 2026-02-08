package com.example.GM.Publication.service;


import com.example.GM.Publication.dto.ProductRequest;
import com.example.GM.Publication.entity.Book;
import com.example.GM.Publication.repository.BookRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(ProductRequest request) {

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
        book.setCoinLimitPercent(request.getCoinLimitPercent());
        book.setAuthorId(request.getAuthorId());
        book.setDemoPdfUrl(request.getDemoPdfUrl());
        book.setFullPdfUrl(request.getFullPdfUrl());
        book.setThumbnailUrl(request.getThumbnailUrl());
        book.setAdPosterUrl(request.getAdPosterUrl());

        // 🪙 Coin limit calculation
        int maxCoins = (int) Math.floor(
                (request.getPrice() * request.getCoinLimitPercent()) / 100
        );
        book.setMaxCoinUsage(maxCoins);

        return bookRepository.save(book);
    }

    @Override
    public Resource getDemoPdf(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return new FileSystemResource(book.getDemoPdfUrl());
    }

    @Override
    public Resource getFullPdf(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return new FileSystemResource(book.getFullPdfUrl());
    }
}
