package com.springboot.service;

import com.springboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    boolean add(Blog blog);
    List<Blog> showList();
    List<Blog> blogOfCategory(String id);
    boolean update(Blog blog);
    Blog findById(int id);
    void delete(Blog blog);
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllPageable(Pageable pageable, String author);
}
