package com.learning.springmvc.service;

import java.util.List;

import com.learning.springmvc.domain.Passenger;

public interface PassengerService {
	
	public Passenger insert(Passenger passenger);
	
	public List<Passenger> getAllPassengers();

}
