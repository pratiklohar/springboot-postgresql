package com.project.springbootpostgresql.service;

import com.project.springbootpostgresql.model.Book;
import com.project.springbootpostgresql.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;


    public List<Book> allBooks() {
        return bookRepo.findAll();
    }

    public Book searchBook(String id) {
        return bookRepo.findById(id).get();
    }

    public List<Book> searchBookByCategory(String category) {
        return bookRepo.findByCategory(category);
    }
    
    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book Deleted";
    }

    public String updateBook(Book book) {
        return bookRepo.updatePrice(book.getPrice(),book.getId()) > 0  ? "Price updated." : "Price update failed.";
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }
}

    
