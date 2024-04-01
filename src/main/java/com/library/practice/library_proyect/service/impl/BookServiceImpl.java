package com.library.practice.library_proyect.service.impl;

import com.library.practice.library_proyect.entities.Book;
import com.library.practice.library_proyect.repository.BookRepository;
import com.library.practice.library_proyect.service.AuthorService;
import com.library.practice.library_proyect.service.BookService;
import com.library.practice.library_proyect.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookRepository.findAll();
        setAuthorsAndPublishersNames(books);
        return books;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book oldBook = bookRepository.findById(id).orElse(null);
        if (oldBook != null){
            oldBook.setName(book.getName());
            oldBook.setDescription(book.getDescription());
            oldBook.setAuthorId(book.getAuthorId());
            oldBook.setPublisherId(book.getPublisherId());
            oldBook.setYearPublished(book.getYearPublished());
            return bookRepository.save(oldBook);
        }
        return null;
    }

    @Override
    public List<Book> getBookByAuthorId(Long id) {
        return bookRepository.getAllByAuthorId(id);
    }

    @Override
    public List<Book> getBookByPublisherId(Long id) {
        return bookRepository.getAllByPublisherId(id);
    }

    @Override
    public List<Book> getLastBooks() {
        List<Book> books = bookRepository.getAllByLastBook();
        setAuthorsAndPublishersNames(books);
        return books;
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    // feature to avoid repetitive code
    private void setAuthorsAndPublishersNames(List<Book> books) {
        for (Book book : books) {
            String authorName = authorService.getAuthorNameById(book.getAuthorId());
            book.setAuthorName(authorName);

            String publisherName = publisherService.getPublisherNameById(book.getPublisherId());
            book.setPublisherName(publisherName);
        }
    }

}
