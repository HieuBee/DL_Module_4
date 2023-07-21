package com.example.cs9.repository;

import com.example.cs9.model.Book;
import com.example.cs9.model.User;
import com.example.cs9.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserBook, Integer> {
    @Query(value = "select user.name, user.phone_number, book.name, book.quantity_borrow, book.category_id from user inner join user_book on user.id = user_book.user_id inner join book on user_book.book_id = book.id group by user.name, user.phone_number, book.name, book.quantity_borrow, book.category_id;",nativeQuery = true)
    List<UserBook> findAllBorrow ();
}
