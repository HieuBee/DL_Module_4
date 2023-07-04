package com.springboot.service;

import com.springboot.model.Category;
import com.springboot.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository service;

    @Override
    public List<Category> findAll() {
        return service.findAll();
    }

    @Override
    public Category findById(int id) {
        return service.findById(id).orElse(null);
    }
}
