package com.onlinebusadda.service;

import java.time.LocalDate;
import java.util.List;

import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.model.Reservation;

public interface ReservationService {

	
	public Reservation addReservation(Reservation reservation) throws ReservationException;
	
	public Reservation updateReservation(Reservation reservation) throws ReservationException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException;
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException;
	
	public List<Reservation> viewAllReservation()throws ReservationException;
	
	public List<Reservation> getAllReservation(LocalDate date)throws ReservationException;
	
}
