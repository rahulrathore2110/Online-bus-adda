package com.onlinebusadda.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity   // Its Bean class so we need to annotate with the annotation @Entity 
public class Reservation {

	@Id 	
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationID;
	@NotNull
    private String reservationStatus;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	@JsonFormat(pattern="yyyy-mm-dd")
	private LocalDate reservationDate;
	@NotNull
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime reservationTime;
	@NotNull
	private String source;
	@NotNull
	private String destination;
	@NotNull
	private Integer noOfSeatsBooked;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Reservation() {}


	public Reservation(Integer reservationID, @NotNull String reservationStatus, @NotNull LocalDate reservationDate,
			@NotNull LocalTime reservationTime, @NotNull String source, @NotNull String destination,
			@NotNull Integer noOfSeatsBooked, Bus bus, User user) {
		super();
		this.reservationID = reservationID;
		this.reservationStatus = reservationStatus;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.bus = bus;
		this.user = user;
	}
	

	
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", reservationStatus=" + reservationStatus
				+ ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + ", source=" + source
				+ ", destination=" + destination + ", noOfSeatsBooked=" + noOfSeatsBooked + ", bus=" + bus + ", user="
				+ user + "]";
	}


		
	public Integer getReservationID() {
		return reservationID;
	}



	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}


	public String getReservationStatus() {
		return reservationStatus;
	}


	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}


	public LocalDate getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}


	public LocalTime getReservationTime() {
		return reservationTime;
	}


	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Integer getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}


	public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
