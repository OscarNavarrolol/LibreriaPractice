package com.library.practice.library_proyect.service;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();
    public Book saveBook (Book Book);

    public Book getBookById(Long id);

    public void deleteBook(Long id);
    public Book updateBook(Long id,Book author);

    public List<Book> getBookByAuthorId (Long id);
    public List<Book> getBookByPublisherId (Long id);

    public List<Book> getLastBooks();
}
