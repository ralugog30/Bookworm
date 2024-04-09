package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Book;
import com.example.bookworm.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {


}
