package com.zynetic2325.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zynetic2325.backend.modal.Book;

import java.util.List;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    List<Book> findByRating(Integer rating);
    List<Book> findByTitleContaining(String title);
}
