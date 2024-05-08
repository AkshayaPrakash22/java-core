package com.example.ebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebook.domain.Book;
import com.example.ebook.services.BookStoreServices;

@RestController
public class BookStoreRestController {

    @Autowired
    private BookStoreServices bookStoreService;

    // Add a new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookStoreService.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    // Update an existing book
    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookStoreService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    // Get all book details
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookStoreService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    // Get single book description based on ID
    @GetMapping("/books/{book_id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("book_id") Long id) {
        Optional<Book> book = bookStoreService.getBookById(id);
    
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete book by ID
    @DeleteMapping("/books/{book_id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("book_id") Long id) {
        bookStoreService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all book details searched based on title
    @GetMapping("/title/{book_title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable("book_title") String title) {
        List<Book> books = bookStoreService.getBooksByTitle(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get all book details searched based on publisher
    @GetMapping("/publisher/{book_publisher}")
    public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable("book_publisher") String publisher)
    {
 
        List<Book> books = bookStoreService.getBooksByPublisher(publisher);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get all book details searched based on the year
    @GetMapping("/years")
    public ResponseEntity<List<Book>> getBooksByYear(@RequestParam("year") int year) {
        List<Book> books = bookStoreService.getBooksByYear(year);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}