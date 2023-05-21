package com.project.springbootpostgresql.service.Impl;

import com.project.springbootpostgresql.dto.BookDTO;
import com.project.springbootpostgresql.model.Book;
import com.project.springbootpostgresql.repository.BookRepo;
import com.project.springbootpostgresql.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    ModelMapper modelMapper = new ModelMapper();


    public BookDTO addBook(BookDTO book) {
        Book bookEntity = modelMapper.map(book, Book.class);
        return modelMapper.map(bookRepo.save(bookEntity), BookDTO.class);
    }

    public List<BookDTO> allBooks() {
        List<Book> bookList = bookRepo.findAll();
        return bookList
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO searchBook(String id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()){
            return modelMapper.map(bookOptional.get(), BookDTO.class);
        }else{
            throw new NoSuchElementException();
        }
    }

    public List<BookDTO> searchBookByCategory(String category) {
        Optional<Book> bookOptional = bookRepo.findByCategory(category);
        if (bookOptional.isPresent()) {
            return  bookOptional
                    .stream()
                    .map(book -> modelMapper.map(book, BookDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new NoSuchElementException();
        }
    }

    public String updateBook(BookDTO book) {
        return bookRepo.updatePrice(book.getPrice(), book.getId()) > 0 ? "Price updated." : "Price update failed.";
    }

    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book Deleted";
    }
}

    
