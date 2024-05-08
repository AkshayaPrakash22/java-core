package com.learning.spring;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Passenger_Details")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Passenger_id")
    private int passenger_id;

    @Column(name = "Passenger_name")
    private String passenger_name;

    @Column(name = "Passenger_dob")
    private LocalDate passenger_dob;

    @Column(name = "Passenger_phone")
    private Long passenger_phone;

    @Column(name = "Passenger_email")
    private String passenger_email;

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(int passenger_id, String passenger_name, LocalDate passenger_dob, Long passenger_phone,
			String passenger_email) {
		super();
		this.passenger_id = passenger_id;
		this.passenger_name = passenger_name;
		this.passenger_dob = passenger_dob;
		this.passenger_phone = passenger_phone;
		this.passenger_email = passenger_email;
	}
	
	

	public Passenger(String passenger_name, LocalDate passenger_dob, Long passenger_phone,
			String passenger_email) {
		super();
		this.passenger_name = passenger_name;
		this.passenger_dob = passenger_dob;
		this.passenger_phone = passenger_phone;
		this.passenger_email = passenger_email;
	}

	
	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public LocalDate getPassenger_dob() {
		return passenger_dob;
	}

	public void setPassenger_dob(LocalDate passenger_dob) {
		this.passenger_dob = passenger_dob;
	}

	public Long getPassenger_phone() {
		return passenger_phone;
	}

	public void setPassenger_phone(Long passenger_phone) {
		this.passenger_phone = passenger_phone;
	}

	public String getPassenger_email() {
		return passenger_email;
	}

	public void setPassenger_email(String passenger_email) {
		this.passenger_email = passenger_email;
	}

	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", passenger_name=" + passenger_name + ", passenger_dob="
				+ passenger_dob + ", passenger_phone=" + passenger_phone + ", passenger_email=" + passenger_email + "]";
	}
	
	

    
}
