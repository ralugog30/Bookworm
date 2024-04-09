package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


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







/*
    default List<Book> filterBooksByCategoryAndAuthor(List<String> selectedBooks) {
        List<Book> selectedCategoryBooks = new ArrayList<>();
        for (String title : selectedBooks) {
            Book selectedBook = findByTitle(title);
            String category = selectedBook.getCategory();
            String author = selectedBook.getAuthor();

            // Filter books by category and author
            List<Book> books = bookRepo.findByCategoryAndAuthor(category, author);
            selectedCategoryBooks.addAll(books);
        }
        return selectedCategoryBooks;
    }

    default Book findByTitleAndAuthor(String titleAndAuthor){
        List<Book> books = findAll();
        String title = titleAndAuthor.strip();
        for(Book b: books){

        }
    }

 */







    //more details: spec+review; get
    //post review





}
