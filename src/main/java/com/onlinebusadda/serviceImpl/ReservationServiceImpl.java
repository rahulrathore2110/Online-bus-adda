package com.onlinebusadda.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.model.Reservation;
import com.onlinebusadda.repository.ReservationRepo;
import com.onlinebusadda.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
	private ReservationRepo repo;
	
	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation viewReservation(Integer reservationId) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewAllReservation() throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

}
