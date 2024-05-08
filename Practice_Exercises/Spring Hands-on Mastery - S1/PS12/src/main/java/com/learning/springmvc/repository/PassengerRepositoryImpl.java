package com.learning.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.learning.springmvc.domain.Passenger;

@Repository("passengerRepository")
@Scope("singleton")
public class PassengerRepositoryImpl  {
	
	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public Passenger insert(Passenger passenger) {
		return mongoTemplate.insert(passenger);
	}
	
	public List<Passenger> getAllPassenger(){
		return mongoTemplate.findAll(Passenger.class);
	}

}
