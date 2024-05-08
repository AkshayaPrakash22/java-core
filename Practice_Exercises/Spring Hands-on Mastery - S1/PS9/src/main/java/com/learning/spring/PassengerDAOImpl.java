package com.learning.spring;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;


public class PassengerDAOImpl implements PassengerDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
	public PassengerDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 
	public void insert(Passenger passenger) {
		// PreparedStatement
		 jdbcTemplate.update(
				"INSERT INTO Passenger_Details VALUES (?,?,?,?,?)", 
				passenger.getPassenger_id(),
				passenger.getPassenger_name(),
				passenger.getPassenger_dob(),
				passenger.getPassenger_phone(),
				passenger.getPassenger_email());
				
	}
 
	public int update(Passenger passenger) {
	    String sql = "update Passenger_Details set Passenger_name='" +
	            passenger.getPassenger_name() +
	            "', Passenger_dob='" +
	            passenger.getPassenger_dob() + 
	            "', Passenger_phone='" +
	            passenger.getPassenger_phone() +
	            "', Passenger_email='" +
	            passenger.getPassenger_email() +
	            "' where Passenger_id=" +
	            passenger.getPassenger_id();
	    return jdbcTemplate.update(sql);
	}
 
	public int delete(final int Passenger_id) {
 
		return jdbcTemplate.update("delete from Passenger_Details where Passenger_id=?", 
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, Passenger_id);
					}
				});
	}
	public List<Passenger> getAllPassengers() {
		return jdbcTemplate.query("select * from Passenger_Details", new PassengerRowMapper());
	}
	public Passenger getPassengerById(int Passenger_id) {
		return jdbcTemplate.query("select * from Passenger_Details where Passenger_id=?",
								new Object[] {Passenger_id}, 
								new PassengerResultsetExtractor() );
	}
}
 
 
