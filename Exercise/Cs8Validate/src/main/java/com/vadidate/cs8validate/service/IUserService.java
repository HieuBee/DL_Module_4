package com.vadidate.cs8validate.service;

import com.vadidate.cs8validate.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean create(User user);
}
