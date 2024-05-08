package com.learning.spring;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PassengerDAOImpl implements PassengerDAO {

	private HibernateTemplate hibernateTemplate;

	public PassengerDAOImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void insert(Passenger passenger) {
		hibernateTemplate.save(passenger);
	}

	public int update(Passenger passenger) {
		hibernateTemplate.update(passenger);
		return 1;
	}

	public int delete(int passenger_id) {
		Passenger passenger = hibernateTemplate.get(Passenger.class, passenger_id);
		if (passenger != null) {
			hibernateTemplate.delete(passenger);
			return 1;
		}
		return 0;
	}

	public List<Passenger> getAllPassengers() {
		return hibernateTemplate.loadAll(Passenger.class);
	}

	public Passenger getPassengerById(int passenger_id) {
		return hibernateTemplate.get(Passenger.class, passenger_id);
	}

}