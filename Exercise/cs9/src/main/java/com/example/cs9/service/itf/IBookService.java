package com.example.cs9.service.itf;

import com.example.cs9.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    boolean create(Book book);
    Book findById(int id);
}
