package com.example.bookworm.Service;

import com.example.bookworm.Entities.Book;
import com.example.bookworm.Entities.Review;
import com.example.bookworm.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public Review getBookById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }
}
