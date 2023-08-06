package com.springboot.dto;

import com.springboot.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogDto implements Validator {
    private int id;
    private String author;
    private String title;
    private String description;
    private String createDate;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String author, String title, String description, String createDate, Category category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
//        Name
        if (blogDto.getAuthor().isEmpty()) {
            errors.rejectValue("author",null,"Cannot be empty!");
        } else if (blogDto.getAuthor().length() < 5 || blogDto.getAuthor().length() > 45){
            errors.rejectValue("author",null,"Required, minimum length 5, maximum 45 characters!");
        }
    }
}
