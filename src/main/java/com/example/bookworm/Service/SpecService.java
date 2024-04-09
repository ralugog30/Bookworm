package com.example.bookworm.Service;

import com.example.bookworm.Entities.Book;
import com.example.bookworm.Entities.Specification;
import com.example.bookworm.Repository.SpecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecService {

    private final SpecRepo specRepo;

    @Autowired
    public SpecService(SpecRepo specRepo) {
        this.specRepo = specRepo;
    }

    public Specification getBookById(Long id) {
        return specRepo.findById(id).orElse(null);
    }
}
