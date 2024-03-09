package com.library.practice.library_proyect.controller;

import com.library.practice.library_proyect.entities.Book;
import com.library.practice.library_proyect.entities.Publisher;
import com.library.practice.library_proyect.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/data")
    public String dataPublisher(Model model){
        List<Publisher> publisherList = publisherService.getAllPublisher();
        model.addAttribute("publisher",publisherList);
        return "PrincipalWeb";
    }

}
