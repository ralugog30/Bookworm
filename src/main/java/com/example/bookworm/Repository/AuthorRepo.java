package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Author;
import com.example.bookworm.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
