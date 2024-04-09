package com.example.bookworm.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_review")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "id_spec")
    private Specifications specifications;


    public Book(Long id, String title, Category category, Author author, Review review, Specifications specifications) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.review = review;
        this.specifications = specifications;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", author=" + author +
                ", review=" + review +
                ", specifications=" + specifications +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }




}







