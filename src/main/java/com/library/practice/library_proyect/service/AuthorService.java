package com.library.practice.library_proyect.service;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AuthorService {

    public List<Author> getAllAuthor();
    public Author saveAuthor (Author author);

    public Author getAuthorById(Long id);

    public void deleteAuthor(Long id);
    public Author updateAuthor(Long id,Author author);

    public String getAuthorNameById(Long id);
}
