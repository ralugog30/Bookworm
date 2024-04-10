package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;

import java.util.*;


public interface BookRepo extends JpaRepository<Book, Long> {

    default List<Book> filteredByCategory(String category) {
        List<Book> books = findAll();
        List<Book> filteredBooks = new ArrayList<>();
        for (Book item : books) {
            if (Objects.equals(item.getCategory(), category))
                filteredBooks.add(item);
        }
        return filteredBooks;


    }

    default List<Book> filteredByAuthor(String author) {
        List<Book> books = findAll();
        List<Book> filteredBooks = new ArrayList<>();
        for (Book item : books) {
            if (Objects.equals(item.getAuthor(), author))
                filteredBooks.add(item);
        }
        return filteredBooks;


    }

    default List<String> getTilesAuthors(){
        List<Book> books = findAll();
        List<String> titlesWithAuthors = new ArrayList<>();
        for(Book b:books){
            String title = b.getTitle();
            String author = b.getAuthor().getName();
            String titleWithAuthor = title + ", " + author ;
            titlesWithAuthors.add(titleWithAuthor);
        }
        return  titlesWithAuthors;

    }

    default List<Book> findBooksByIds(List<Long> bookIds) {
        return findAllById(bookIds);
    }



    default List<Book> filterBooksByCategoryAndAuthor(List<Long> selectedBookIds) {
        // Find all selected books by their IDs
        List<Book> selectedBooks = findBooksByIds(selectedBookIds);

        // Filter books based on category or author
        List<Book> filteredBooks =findAll().stream()
                .filter(book -> selectedBooks.stream()
                        .anyMatch(selectedBook ->
                                book.getCategory().equals(selectedBook.getCategory()) ||
                                        book.getAuthor().equals(selectedBook.getAuthor())))
                .collect(Collectors.toList());

        return filteredBooks;
    }
















    //more details: spec+review; get
    //post review





}
