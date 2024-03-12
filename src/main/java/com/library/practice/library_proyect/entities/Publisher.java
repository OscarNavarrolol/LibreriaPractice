package com.library.practice.library_proyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "publisher_id")
    private Long publisherId;

    private String name;
    private String location;

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
