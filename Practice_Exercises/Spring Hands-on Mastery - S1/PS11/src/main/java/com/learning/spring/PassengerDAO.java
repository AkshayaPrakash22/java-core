package com.learning.spring;

import java.util.List;

public interface PassengerDAO {
    public int save(Passenger passenger);
    public void update(Passenger passenger);
    public int delete(int id);
    public Passenger get(int id);
    public List<Passenger> loadAll();
}