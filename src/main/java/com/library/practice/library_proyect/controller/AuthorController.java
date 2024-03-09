package com.library.practice.library_proyect.controller;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/general")
    public String  principalWeb(){
        return "PrincipalWeb";
    }

    @GetMapping("/data")
    public String dataAuthor(Model model){
        List<Author> authorList = authorService.getAllAuthor();
        model.addAttribute("author",authorList);
        return "PrincipalWeb";
    }
}
