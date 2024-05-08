package com.example.ebook;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.stereotype.Service;

@Service
public class BookStoreServices {

    @Autowired
    private BookRepository bookRepository;

    private Jedis jedis;
    public BookStoreServices() {
        this.jedis = new Jedis();
    }
    
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
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public void deleteBookById(Long id) {
    	bookRepository.deleteById(id);
    }
}