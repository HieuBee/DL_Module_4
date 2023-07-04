package com.springboot.repository;

import com.springboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select blog.id , blog.author, blog.description, blog.title, blog.category_id, category.category from blog left join category on blog.category_id = category.id",nativeQuery = true)
    List<Blog> showList();

    @Query(value = " select * from blog left join category on blog.category_id = category.id where blog.category_id = :id",nativeQuery = true)
    List<Blog> blogOfCategory(@Param("id") String id);

    @Query(value = "select * from blog left join category on blog.category_id = category.id where blog.author like :author order by blog.create_date",nativeQuery = true)
    Page<Blog> findAllPageable(Pageable pageable, @Param("author") String author);
}
