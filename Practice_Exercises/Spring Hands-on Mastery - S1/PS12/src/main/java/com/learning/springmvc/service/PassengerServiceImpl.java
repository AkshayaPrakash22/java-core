package com.learning.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.learning.springmvc.domain.Passenger;
import com.learning.springmvc.repository.PassengerRepo;

public class PassengerServiceImpl implements PassengerService {

	@Autowired
	@Qualifier("passengerRepository")
	private PassengerRepo passengerRepository;
 
	@Override
	public Passenger insert(Passenger passenger) {
		return passengerRepository.insert(passenger);
	}

	public List<Passenger> getAllPassengers(){
		return passengerRepository.getAllPassengers();
	}

}
