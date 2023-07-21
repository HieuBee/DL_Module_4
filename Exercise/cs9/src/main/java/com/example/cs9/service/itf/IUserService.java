package com.example.cs9.service.itf;

import com.example.cs9.model.Book;
import com.example.cs9.model.User;
import com.example.cs9.model.UserBook;

import java.util.List;

public interface IUserService {
    /*List<Book> listBorrowBook();*/
    List<UserBook> findAll();
    UserBook borrowBook(UserBook userBook);
    void returnBook(UserBook userBook);
}
