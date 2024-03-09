package com.library.practice.library_proyect.controller;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.entities.Book;
import com.library.practice.library_proyect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/data")
    public String dataBook(Model model){
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("book",bookList);
        return "PrincipalWeb";
    }

}
