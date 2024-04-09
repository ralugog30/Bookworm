package com.example.bookworm.Conntroller;


import com.example.bookworm.Entities.*;
import com.example.bookworm.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/book")
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
    public ResponseEntity<Specification> getSpecificationForBook(@PathVariable Long bookId) throws Exception {
        Specification specification= bookService.getSpecForBook(bookId);
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


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = (List<Book>) bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
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



}
