package com.example.bookworm.Service;

import com.example.bookworm.Entities.Book;
import com.example.bookworm.Entities.Category;
import com.example.bookworm.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    public Category getBookById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }
}
