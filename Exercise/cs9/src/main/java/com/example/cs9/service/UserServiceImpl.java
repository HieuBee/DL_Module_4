package com.example.cs9.service;

import com.example.cs9.model.Book;
import com.example.cs9.model.User;
import com.example.cs9.model.UserBook;
import com.example.cs9.repository.IUserRepository;
import com.example.cs9.service.itf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<UserBook> findAll() {
        return repository.findAll();
    }

    @Override
    public UserBook borrowBook(UserBook userBook) {
        return repository.save(userBook);
    }

    @Override
    public void returnBook(UserBook userBook) {
        repository.delete(userBook);
    }
}
