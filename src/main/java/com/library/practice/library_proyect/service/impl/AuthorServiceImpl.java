package com.library.practice.library_proyect.service.impl;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.repository.AuthorRepository;
import com.library.practice.library_proyect.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author oldAuthor = authorRepository.findById(id).orElse(null);
        if (oldAuthor != null){
            oldAuthor.setName(author.getName());
            oldAuthor.setNationality(author.getNationality());
            return authorRepository.save(oldAuthor);
        }
        return null;
    }

    @Override
    public String getAuthorNameById(Long id) {
        Author author= authorRepository.findById(id).orElse(null);
        if (author != null){
            String nameAuthor = author.getName();
            return nameAuthor;
        }
        return null;

    }
}
