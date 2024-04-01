package com.library.practice.library_proyect.service;

import org.springframework.data.domain.Pageable;
import com.library.practice.library_proyect.entities.Book;
import org.springframework.data.domain.Page;

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

    public Page<Book> getAllBooks(Pageable pageable);
}
