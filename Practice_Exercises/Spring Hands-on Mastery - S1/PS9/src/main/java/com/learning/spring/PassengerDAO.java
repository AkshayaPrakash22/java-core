package com.learning.spring;

import java.util.List;

public interface PassengerDAO {

	public void insert(Passenger passenger);

	public int update(Passenger passenger);

	public int delete(int Passenger_id);

	public List<Passenger> getAllPassengers();

	public Passenger getPassengerById(int Passenger_id);

}
