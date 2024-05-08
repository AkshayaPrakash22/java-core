package com.learning.spring;

import java.time.LocalDate;
import java.util.Date;

public class Passenger {
	private int Passenger_id;
	private String Passenger_name;
	private LocalDate Passenger_dob;
	private Long Passenger_phone;
	private String Passenger_email;

	public Passenger() {
	}

	public Passenger(int passenger_id, String passenger_name, LocalDate passenger_dob, Long passenger_phone,
			String passenger_email) {
		super();
		Passenger_id = passenger_id;
		Passenger_name = passenger_name;
		Passenger_dob = passenger_dob;
		Passenger_phone = passenger_phone;
		Passenger_email = passenger_email;
	}

	public Passenger(String passenger_name, LocalDate passenger_dob, Long passenger_phone, String passenger_email) {
		super();
		Passenger_name = passenger_name;
		Passenger_dob = passenger_dob;
		Passenger_phone = passenger_phone;
		Passenger_email = passenger_email;
	}

	public int getPassenger_id() {
		return Passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		Passenger_id = passenger_id;
	}

	public String getPassenger_name() {
		return Passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		Passenger_name = passenger_name;
	}

	public LocalDate getPassenger_dob() {
		return Passenger_dob;
	}

	public void setPassenger_dob(LocalDate passenger_dob) {
		Passenger_dob = passenger_dob;
	}

	public Long getPassenger_phone() {
		return Passenger_phone;
	}

	public void setPassenger_phone(Long passenger_phone) {
		Passenger_phone = passenger_phone;
	}

	public String getPassenger_email() {
		return Passenger_email;
	}

	public void setPassenger_email(String passenger_email) {
		Passenger_email = passenger_email;
	}

	@Override
	public String toString() {
		return "Passenger [Passenger_id=" + Passenger_id + ", Passenger_name=" + Passenger_name + ", Passenger_dob="
				+ Passenger_dob + ", Passenger_phone=" + Passenger_phone + ", Passenger_email=" + Passenger_email + "]";
	}

}
