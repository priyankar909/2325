package com.zynetic2325.backend.service;

import com.zynetic2325.backend.modal.Book;
import com.zynetic2325.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    // Save a new book or update an existing one
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Get a book by its ID
    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    // Delete a book by its ID
    public void deleteBook(Long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with ID: " + id);
        }
    }

    // Get books by author
    public List<Book> getByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    // Get books by category
    public List<Book> getByCategory(String category) {
        return bookRepo.findByCategory(category);
    }

    // Get books by rating
    public List<Book> getByRating(Integer rating) {
        return bookRepo.findByRating(rating);
    }

    // Search books by title
    public List<Book> searchByTitle(String title) {
        return bookRepo.findByTitleContaining(title);
    }
}
