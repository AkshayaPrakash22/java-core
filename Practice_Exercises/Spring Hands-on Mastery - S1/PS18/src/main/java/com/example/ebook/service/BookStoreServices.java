package com.example.ebook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ebook.domain.Book;
import com.example.ebook.repo.BookRepository;

@Service
public class BookStoreServices {
 private static Logger log=LoggerFactory.getLogger(BookStoreServices.class);
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> getBooksByYear(int year) {
        return bookRepository.findByYear(year);
    }

    public Book addBook(Book book) {
    	log.info("Book inserted");
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public void deleteBookById(Long id) {
    	bookRepository.deleteById(id);
    }
}