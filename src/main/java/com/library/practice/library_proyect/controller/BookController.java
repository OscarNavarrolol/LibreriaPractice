package com.library.practice.library_proyect.controller;


import com.library.practice.library_proyect.entities.Book;
import com.library.practice.library_proyect.service.AuthorService;
import com.library.practice.library_proyect.service.BookService;
import com.library.practice.library_proyect.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/general")
    public String  principalWeb(Model model){
        List<Book> listLastBooks = bookService.getLastBooks();
        model.addAttribute("lastBooks", listLastBooks);
        return "PrincipalWeb";
    }

    @GetMapping("/data")
    public String dataBook(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 9);
        Page<Book> bookList = bookService.getAllBooks(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("book",bookList);
        return "Catalog";
    }

    @GetMapping("/contact")
    public String contactInformation(){
        return "Contact";
    }

}
