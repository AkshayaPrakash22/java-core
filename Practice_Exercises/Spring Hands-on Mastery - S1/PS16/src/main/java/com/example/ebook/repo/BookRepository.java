package com.example.ebook.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ebook.domain.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId>{
	
	    //List<Book> findById(ObjectId id);

	    // Find book by title
		List<Book> findByTitle(String title);

		// Find book by publisher
		List<Book> findByPublisher(String publisher);

		// Find book by year
		List<Book> findByYear(int year);
}
