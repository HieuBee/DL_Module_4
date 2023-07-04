package com.springboot.service;

import com.springboot.model.Blog;
import com.springboot.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    private IBlogRepository repository;


    @Override
    public boolean add(Blog blog) {
        Blog blogAdd = repository.save(blog);
        return blogAdd != null;
    }

    @Override
    public List<Blog> showList() {
        return repository.showList();
    }

    @Override
    public List<Blog> blogOfCategory(String id) {
        return repository.blogOfCategory(id);
    }

    @Override
    public boolean update(Blog blog) {
        Blog blogAdd = repository.save(blog);
        return blogAdd != null;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Blog blog) {
        repository.deleteById(blog.getId());
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllPageable(Pageable pageable, String author) {
        return repository.findAllPageable(pageable, "%" + author + "%");
    }

}
