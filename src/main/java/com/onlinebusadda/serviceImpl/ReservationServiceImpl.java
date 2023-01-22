package com.onlinebusadda.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Bus;
import com.onlinebusadda.model.CurrentUserSession;
import com.onlinebusadda.model.Reservation;
import com.onlinebusadda.model.User;
import com.onlinebusadda.repository.BusRepo;
import com.onlinebusadda.repository.CurrentUserSessionRepo;
import com.onlinebusadda.repository.ReservationRepo;
import com.onlinebusadda.repository.UserRepo;
import com.onlinebusadda.service.ReservationService;

// This is a service layer class which contains the main business logic..!
@Service 
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepo reservationRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	
	@Override
	public Reservation addReservation(Reservation reservation, Integer userLoginId, String uuid)
			throws ReservationException, BusException, UserException {
		
       CurrentUserSession loggedInUser= currentUserSessionRepo.findByUuid(uuid);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid User key to reserve seats...!");
		}
		
		Bus bus =	busRepo.findById(reservation.getBus().getBusId()).orElseThrow(() -> new BusException("Bus not found with busId "+reservation.getBus().getBusId()));
		
		User user = userRepo.findById(userLoginId).orElseThrow(()-> new UserException("User not found with userId "+userLoginId));
		
		 if(bus.getAvailableSeats()<=0 || bus.getAvailableSeats()- reservation.getNoOfSeatsBooked() <= 0) 
			 throw new ReservationException("All Bus seats are booked...!");
			
			
		bus.setAvailableSeats(bus.getAvailableSeats()-reservation.getNoOfSeatsBooked());
		
		busRepo.save(bus);
		
		reservation.setBus(bus);
		reservation.setReservationStatus("Reservation is Confirmed..!");
		reservation.setReservationDate(LocalDate.now());
		reservation.setReservationTime(LocalTime.now());
		reservation.setSource(bus.getRoute().getRoutefrom());
		reservation.setDestination(bus.getRoute().getRouteto());
		reservation.setNoOfSeatsBooked(reservation.getNoOfSeatsBooked());
		
		List<Reservation> reservationList = user.getReservation();
		
		reservationList.add(reservation);
		
		user.setReservation(reservationList);
		
		reservation.setUser(user);
	
		return	reservationRepo.save(reservation);
		
		
	}

	@Override
	public Reservation deleteReservation(Integer reservationId, String uuid)
			throws ReservationException, BusException, UserException {

        CurrentUserSession loggedInUser= currentUserSessionRepo.findByUuid(uuid);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid User key...!");
		}
		
			
		Optional<Reservation> reservationObject = reservationRepo.findById(reservationId);
		
		if(reservationObject.isEmpty()) {
			 throw new ReservationException("Reservation details not found with reservationId "+reservationId);
		}
		
		Reservation  reservation =  reservationObject.get();
		
		User userObject = userRepo.findByEmail(loggedInUser.getEmail());
		
		if(userObject == null) {
			 new UserException("User not found with respective ID ");
		}
			
			reservationRepo.delete(reservation);
			
			return reservation;
		
	}

	
	@Override
	public Reservation viewReservation(Integer reservationId, String uuid) throws ReservationException, UserException {
		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(uuid);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid uid to view reservation..!");
		}
		
		Optional<Reservation> Optional = reservationRepo.findById(reservationId);
		Reservation foundReservation = Optional.orElseThrow(()-> new ReservationException("No reservation found with reservationId "+reservationId));
		
		return foundReservation;
	}
	

	@Override
	public List<Reservation> viewAllReservation(String uuid) throws ReservationException {
        
		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(uuid);
		
		if(loggedInUser == null) {
			throw new ReservationException("Please provide a valid uid to view all reservations...!");
		}
		
        List<Reservation> reservationList = reservationRepo.findAll();
		
		if(reservationList.size() > 0) {
			return reservationList;
		}
		else
			throw new ReservationException("No respective Reservation Found...!");
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException {
		
		List<Reservation> lists = reservationRepo.findByReservationDate(date);
		
		if(lists.size() > 0)
			return lists;
		else
			throw new ReservationException("error occurred while retrieving reservations for the given date "+date);
	}
	
}
