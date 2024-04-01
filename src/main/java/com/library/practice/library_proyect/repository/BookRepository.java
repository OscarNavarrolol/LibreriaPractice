package com.library.practice.library_proyect.repository;

import com.library.practice.library_proyect.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "SELECT * FROM book b WHERE b.author_id = ?1", nativeQuery = true)
    List<Book> getAllByAuthorId(Long id);

    @Query(value = "SELECT * FROM book b WHERE b.publisher_id = ?1", nativeQuery = true)
    List<Book> getAllByPublisherId(Long id);

    @Query(value = "SELECT * FROM book ORDER BY id DESC", nativeQuery = true)
    List<Book> getAllByLastBook();

    @Query(value = "SELECT b FROM Book b")
    Page<Book> booksLimited(Pageable pageable);
}
