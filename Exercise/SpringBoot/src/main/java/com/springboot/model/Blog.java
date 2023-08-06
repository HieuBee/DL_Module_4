package com.springboot.model;

import com.springboot.dto.BlogDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
public class Blog implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Column(columnDefinition = "date")
    private String createDate;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String author, String title, String description, String createDate, Category category) {
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
        Blog blog = (Blog) target;
//        Name
        if (blog.getAuthor().isEmpty()) {
            errors.rejectValue("author",null,"Cannot be empty!");
        } else if (blog.getAuthor().length() < 5 || blog.getAuthor().length() > 45){
            errors.rejectValue("author",null,"Required, minimum length 5, maximum 45 characters!");
        }
    }
}
