package com.example.bookworm.Service;

import com.example.bookworm.Entities.Author;
import com.example.bookworm.Entities.Book;
import com.example.bookworm.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author getBookById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }
}
