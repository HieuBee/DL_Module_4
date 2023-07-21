package com.example.cs9.controller;

import com.example.cs9.model.Book;
import com.example.cs9.model.User;
import com.example.cs9.model.UserBook;
import com.example.cs9.service.itf.IBookService;
import com.example.cs9.service.itf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String listBook(Model model){
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("book", new Book());
        model.addAttribute("userBook", new UserBook());
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/listBorrowBook")
    public String listBorrowBook(Model model){
        model.addAttribute("userBook", new UserBook());
        model.addAttribute("listBorrowBook", userService.findAll());
        return "listBorrowBook";
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@ModelAttribute UserBook userBook, RedirectAttributes redirectAttributes){
        int min = 10000;
        int max = 99999;
        List<UserBook> userBookList = userService.findAll();
        for (UserBook ub : userBookList) {
            if (ub.getCode() != userBook.getCode()){
                userBook.setCode((int)Math.floor(Math.random() * (max - min + 1) + min));
                Book book = bookService.findById(userBook.getBook().getId());
                int quantity = book.getQuantity() - userBook.getQuantity();
                book.setQuantity(quantity);
                bookService.create(book);
                userService.borrowBook(userBook);
                redirectAttributes.addFlashAttribute("messBorrowBook", "Success Borrow Book!");
                return "redirect:/book/listBorrowBook";
            }
        }
        redirectAttributes.addFlashAttribute("messBorrowBook", "Fail Borrow Book!");
        return "redirect:/book/listBorrowBook";
    }

    @PostMapping("/returnBook")
    public String returnBook(@ModelAttribute UserBook userBook, RedirectAttributes redirectAttributes){
        List<UserBook> userBookList = userService.findAll();
        for (UserBook ub : userBookList) {
            if (userBook.getCode() == ub.getCode()){
                Book book = bookService.findById(ub.getBook().getId());
                int quantity = book.getQuantity() + userBook.getQuantity();
                book.setQuantity(quantity);
                bookService.create(book);
                userService.returnBook(ub);
                System.out.println();
                redirectAttributes.addFlashAttribute("messBorrowBook", "Success Return Book!");
                return "redirect:/book/listBorrowBook";
            }
        }
        redirectAttributes.addFlashAttribute("messBorrowBook", "Fail Return Book!");
        return "redirect:/book/listBorrowBook";
    }
}
