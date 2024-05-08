package com.learning.springmvc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.springmvc.domain.Passenger;

public interface PassengerRepo extends MongoRepository<Passenger, Integer>{
	
	public Passenger insert(Passenger passenger);
	
	public List<Passenger> getAllPassengers();

}
