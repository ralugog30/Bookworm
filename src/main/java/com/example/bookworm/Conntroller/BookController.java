package com.example.bookworm.Conntroller;


import com.example.bookworm.Entities.*;
import com.example.bookworm.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}/review")
    public ResponseEntity<Review> getReviewForBook(@PathVariable Long bookId) throws Exception {
        Review review= bookService.getReviewForBook(bookId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("/{bookId}/specification")
    public ResponseEntity<Specifications> getSpecificationForBook(@PathVariable Long bookId) throws Exception {
        Specifications specification= bookService.getSpecForBook(bookId);
        return new ResponseEntity<>(specification, HttpStatus.OK);
    }

    @GetMapping("/{bookId}/category")
    public ResponseEntity<Category> getCategoryForBook(@PathVariable Long bookId) throws Exception {
        Category category= bookService.getCategoryForBook(bookId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/{bookId}/author")
    public ResponseEntity<Author> getAuthorForBook(@PathVariable Long bookId) throws Exception {
        Author author= bookService.getAuthorForBook(bookId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }





    @GetMapping("/filterByAuthor")
    public List<Book> filterByAuthor(@RequestParam String author) {
        return bookService.filterByAuthor(author);
    }

    @GetMapping("/filterByCategory")
    public List<Book> filterByCategory(@RequestParam String category) {
        return bookService.filterByCategory(category);
    }


    @PostMapping("/{bookId}/postReview")
    public ResponseEntity<String> addReviewToBook(@PathVariable Long bookId, @RequestBody Review review) {
        try {
            bookService.addReviewToBook(bookId, review);
            return ResponseEntity.status(HttpStatus.CREATED).body("Review added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add review: " + e.getMessage());
        }
    }


    @GetMapping("/titlesAndAuthors")
    public ResponseEntity<List<String>> getTitlesAuthors() {
        List<String> titlesAuthors = bookService.titlesWithAuthors();
        return new ResponseEntity<>(titlesAuthors, HttpStatus.OK);
    }





    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();

        Collections.shuffle(allBooks);

        List<Book> randomBooks = allBooks.subList(0, Math.min(20, allBooks.size()));
        return randomBooks;
    }

 /*

    @GetMapping
    public List<Map<String, String>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();

        Collections.shuffle(allBooks);

        List<Book> randomBooks = allBooks.subList(0, Math.min(20, allBooks.size()));

        List<Map<String, String>> booksData = new ArrayList<>();
        for (Book book : randomBooks) {
            Map<String, String> bookData = new HashMap<>();
            bookData.put("title", book.getTitle());
            bookData.put("authorName", book.getAuthor().getName());
            booksData.add(bookData);
        }

        return booksData;
    }

 */




    ////da eu primesc lista de int sau long?????????????????????????????????
    @GetMapping("/suggestions")
    public List<Book> getFilteredSuggestions(@RequestParam List<Long> selectedBooks) {
        return bookService.filterBooksByCategoryAndAuthor(selectedBooks);
    }


    @GetMapping("/submit-books")
    public List<Book> submitSelectedBooks(@RequestBody List<Long> selectedBooks) {
     return bookService.filterBooksByCategoryAndAuthor(selectedBooks);
    }











}
