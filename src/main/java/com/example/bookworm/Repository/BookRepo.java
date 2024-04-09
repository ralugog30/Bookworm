package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
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



    //more details: spec+review; get
    //post review





}
