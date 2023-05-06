package com.project.springbootpostgresql.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "book")
public class Book {

    @Id
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private int  quantity;
    @Column(name = "price")
    private float price;
}