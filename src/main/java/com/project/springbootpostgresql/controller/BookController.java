package com.project.springbootpostgresql.controller;

import com.project.springbootpostgresql.dto.BookDTO;
import com.project.springbootpostgresql.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public BookDTO addBook(@Valid @RequestBody BookDTO book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<BookDTO> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/book/{id}")
    public BookDTO searchBook(@PathVariable String id){
        return bookService.searchBook(id);
    }

    @GetMapping("/book")
    public List<BookDTO> searchBookByCategory(@RequestParam String category){
        return bookService.searchBookByCategory(category);
    }

    @PatchMapping("/book")
    public String updateBook(@RequestBody BookDTO book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }

}
