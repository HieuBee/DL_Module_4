package com.example.cs9.service;

import com.example.cs9.model.Book;
import com.example.cs9.repository.IBookRepository;
import com.example.cs9.service.itf.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository repository;
    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Book book) {
        Book book1 = repository.save(book);
        return book1 != null;
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
