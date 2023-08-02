package com.springboot.controller;


import com.springboot.model.Blog;
import com.springboot.model.Category;
import com.springboot.service.IBlogService;
import com.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/product")
public class RestBlogController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/get-category")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> getAll = categoryService.findAll();
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/get-list-blog")
    public ResponseEntity<Page<Blog>> getBlog(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/get-book-detail")
    public ResponseEntity<Blog> getBookDetail(@RequestParam int id) {
        List<Blog> blogs = blogService.showList();
        Blog blog = blogService.findById(id);
        if (blogs.contains(blog)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/get-book-by-category")
    public ResponseEntity<List<Blog>> getBookByCategory(@RequestParam String id) {
        List<Blog> blogs = blogService.blogOfCategory(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
