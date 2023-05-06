package com.project.springbootpostgresql.controller;

import com.project.springbootpostgresql.model.Book;
import com.project.springbootpostgresql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/book/{id}")
    public Book searchBook(@PathVariable String id){
        return bookService.searchBook(id);
    }

    @GetMapping("/book")
    public List<Book> searchBookByCategory(@RequestParam String category){
        return bookService.searchBookByCategory(category);
    }

    @PatchMapping("/book")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }

}
