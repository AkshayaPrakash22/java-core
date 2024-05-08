package com.learning.spring;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class PassengerResultsetExtractor implements ResultSetExtractor<Passenger> {

	public Passenger extractData(ResultSet rs) throws SQLException, DataAccessException {

		if (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setPassenger_id(rs.getInt("Passenger_id"));
			passenger.setPassenger_name(rs.getString("Passenger_name"));
			Date dob=rs.getDate("Passenger_dob");
	        passenger.setPassenger_dob(dob.toLocalDate());
			passenger.setPassenger_phone(rs.getLong("Passenger_phone"));
			passenger.setPassenger_email(rs.getString("Passenger_email"));
			return passenger;
		}
		return null;
	}
}
