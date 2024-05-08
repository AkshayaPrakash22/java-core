package com.learning.springmvc.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "passenger")
public class Passenger {
	
	@Id
    private int passengerId;
    private String passengerName;
    
    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate passengerDob;
    private Long passengerPhone;
    private String passengerEmail;
    
  

   

    public Passenger(int passengerId, String passengerName, LocalDate passengerDob, Long passengerPhone,
			String passengerEmail) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerDob = passengerDob;
		this.passengerPhone = passengerPhone;
		this.passengerEmail = passengerEmail;
	}



	public int getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}



	public String getPassengerName() {
		return passengerName;
	}



	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}



	public LocalDate getPassengerDob() {
		return passengerDob;
	}



	public void setPassengerDob(LocalDate passengerDob) {
		this.passengerDob = passengerDob;
	}



	public Long getPassengerPhone() {
		return passengerPhone;
	}



	public void setPassengerPhone(Long passengerPhone) {
		this.passengerPhone = passengerPhone;
	}



	public String getPassengerEmail() {
		return passengerEmail;
	}



	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}



	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerDob="
				+ passengerDob + ", passengerPhone=" + passengerPhone + ", passengerEmail=" + passengerEmail + "]";
	}
    
    


}