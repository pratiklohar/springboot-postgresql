package com.project.springbootpostgresql.service;

import com.project.springbootpostgresql.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO addBook(BookDTO book);  //create

    List<BookDTO> allBooks();   //read

    BookDTO searchBook(String id);  //read

    List<BookDTO> searchBookByCategory(String category);  //read

    String updateBook(BookDTO book);    //update

    String deleteBook(String id); //delete


}
