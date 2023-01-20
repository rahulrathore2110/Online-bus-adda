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
	private ReservationRepo reservationRepo;
	
	@Override
	public Reservation addReservation(Reservation reservation, String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation updateReservation(Reservation reservation, String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation viewReservation(Integer reservationId, String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewAllReservation(String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

}
