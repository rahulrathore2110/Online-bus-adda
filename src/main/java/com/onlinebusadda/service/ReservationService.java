package com.onlinebusadda.service;

import java.time.LocalDate;
import java.util.List;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Reservation;

public interface ReservationService {

	
	public Reservation addReservation(Reservation reservation) throws ReservationException, BusException, UserException;
	
	public Reservation updateReservation(Reservation reservation) throws ReservationException, UserException, BusException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException, BusException, UserException;
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException;
	
	public List<Reservation> viewAllReservation()throws ReservationException;
	
	public List<Reservation> getAllReservation(LocalDate date)throws ReservationException;
	
}
