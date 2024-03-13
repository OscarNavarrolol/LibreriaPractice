package com.library.practice.library_proyect.service.impl;

import com.library.practice.library_proyect.entities.Author;
import com.library.practice.library_proyect.entities.Publisher;
import com.library.practice.library_proyect.repository.PublisherRepository;
import com.library.practice.library_proyect.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {


    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher updatePublisher(Long id, Publisher publisher) {
        Publisher oldPublisher = publisherRepository.findById(id).orElse(null);
        if (oldPublisher != null){
            oldPublisher.setName(publisher.getName());
            oldPublisher.setLocation(publisher.getLocation());
            return publisherRepository.save(oldPublisher);
        }
        return null;
    }

    @Override
    public String getPublisherNameById(Long id) {
        Publisher publisher =publisherRepository.findById(id).orElse(null);
        if (publisher != null){
            String namePublisher = publisher.getName();
            return namePublisher;
        }
        return null;
    }
}
