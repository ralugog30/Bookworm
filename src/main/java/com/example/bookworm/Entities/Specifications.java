package com.example.bookworm.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "specifications")
public class Specifications{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private int year;

    public Specifications(Long id, String description, int year) {
        this.id = id;
        this.description = description;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", year=" + year +
                '}';
    }

    public Specifications() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

