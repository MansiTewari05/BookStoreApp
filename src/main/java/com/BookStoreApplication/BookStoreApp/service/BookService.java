package com.BookStoreApplication.BookStoreApp.service;

import com.BookStoreApplication.BookStoreApp.model.Book;
import com.BookStoreApplication.BookStoreApp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setCondition(bookDetails.getCondition());
            book.setAvailable(bookDetails.isAvailable());
            book.setOwner(bookDetails.getOwner());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title, String author, String genre) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContaining(author);
        } else if (genre != null && !genre.isEmpty()) {
            return bookRepository.findByGenre(genre);
        } else {
            return bookRepository.findAll();
        }
    }
}

