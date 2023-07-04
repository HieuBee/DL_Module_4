package com.springboot.service;

import com.springboot.model.Blog;
import com.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService{
    List<Category> findAll();
    Category findById(int id);
}
