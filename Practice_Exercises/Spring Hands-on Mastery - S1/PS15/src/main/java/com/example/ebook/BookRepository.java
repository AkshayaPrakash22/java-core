package com.example.ebook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	// Find book by title
	List<Book> findByTitle(String title);

	// Find book by publisher
	List<Book> findByPublisher(String publisher);

	// Find book by year
	List<Book> findByYear(int year);
}
