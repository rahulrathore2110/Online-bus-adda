package com.onlinebusadda.service;

import java.time.LocalDate;
import java.util.List;
import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Reservation;

public interface ReservationService {

	
	public Reservation addReservation(Reservation reservation, Integer userLoginId, String uuid) throws ReservationException, BusException, UserException;
	
	public Reservation deleteReservation(Integer reservationId, String uuid) throws ReservationException, BusException, UserException;
	
	public Reservation viewReservation(Integer reservationId, String uuid) throws ReservationException, UserException;
	
	public List<Reservation> viewAllReservation(String uuid)throws ReservationException;
	
	public List<Reservation> getAllReservation(LocalDate date)throws ReservationException;
	
}
