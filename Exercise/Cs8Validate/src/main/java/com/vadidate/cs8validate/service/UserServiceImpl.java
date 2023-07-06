package com.vadidate.cs8validate.service;

import com.vadidate.cs8validate.model.User;
import com.vadidate.cs8validate.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(User user) {
        User user1 = repository.save(user);
        return user1 != null;
    }
}
