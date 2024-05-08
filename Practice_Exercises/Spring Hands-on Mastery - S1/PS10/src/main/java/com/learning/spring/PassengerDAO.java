package com.learning.spring;

import java.util.List;

public interface PassengerDAO {

    void insert(Passenger passenger);

    int update(Passenger passenger);

    int delete(int passenger_id);

    List<Passenger> getAllPassengers();

    Passenger getPassengerById(int passenger_id);
}