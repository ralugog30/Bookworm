package com.example.bookworm.Repository;

import com.example.bookworm.Entities.Book;
import com.example.bookworm.Entities.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecRepo extends JpaRepository<Specification, Long> {
}
