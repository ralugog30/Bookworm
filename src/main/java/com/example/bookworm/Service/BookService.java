package com.example.bookworm.Service;

import com.example.bookworm.Entities.*;
import com.example.bookworm.Repository.BookRepo;
import com.example.bookworm.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class BookService {


    private final BookRepo bookRepo;

    private  ReviewRepo reviewRepo;

    @Autowired
    public BookService(BookRepo bookRepo, ReviewRepo reviewRepo) {
        this.bookRepo = bookRepo;
        this.reviewRepo = reviewRepo;
    }




    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Review getReviewForBook(Long bookId) throws Exception {
       Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new Exception("Book not found with id " + bookId));

        return book.getReview();
    }

    public Category getCategoryForBook(Long bookId) throws Exception {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new Exception("Book not found with id " + bookId));

        return book.getCategory();
    }

    public Author getAuthorForBook(Long bookId) throws Exception {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new Exception("Book not found with id " + bookId));

        return book.getAuthor();
    }

    public Specifications getSpecForBook(Long bookId) throws Exception {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new Exception("Book not found with id " + bookId));

        return book.getSpecifications();
    }


    public List<Book> getAllBooks(){
        List<Book> books = bookRepo.findAll();
        return books;
    }

    public List<Book> filterByCategory(String category) {
        List<Book> filteredBooks = bookRepo.filteredByCategory(category);

        return filteredBooks;

    }

    public List<Book> filterByAuthor(String author) {
        List<Book> filteredBooks = bookRepo.filteredByAuthor(author);

        return filteredBooks;


    }


    public void addReviewToBook(Long bookId, Review review) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        reviewRepo.save(review);

        book.setReview(review);

        bookRepo.save(book);
    }

    public List<String> titlesWithAuthors(){
        return bookRepo.getTilesAuthors();
    }







}
