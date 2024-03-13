package com.library.practice.library_proyect.service;

import com.library.practice.library_proyect.entities.Book;
import com.library.practice.library_proyect.entities.Publisher;

import java.util.List;

public interface PublisherService {

    public List<Publisher> getAllPublisher();
    public Publisher savePublisher (Publisher publisher);

    public Publisher getPublisherById(Long id);

    public void deletePublisher(Long id);
    public Publisher updatePublisher(Long id,Publisher publisher);

    public String getPublisherNameById(Long id);
}
