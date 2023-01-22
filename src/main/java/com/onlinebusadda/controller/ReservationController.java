package com.onlinebusadda.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.ReservationException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Reservation;
import com.onlinebusadda.service.ReservationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


// This class is a controller layer, which contains the persistence logic.
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;

	
	@PostMapping("/addReservation/{key}")
	public ResponseEntity<Reservation> addReservationController(@Valid @RequestBody Reservation reservation, @RequestParam(required = false) Integer userLoginId, @PathVariable("key") String uuid) throws ReservationException, BusException, UserException{

		Reservation reservationBooked = reservationService.addReservation(reservation, userLoginId, uuid);
		
		return new ResponseEntity<Reservation>(reservationBooked, HttpStatus.ACCEPTED);
	
	}
	
	
	@DeleteMapping("/deleteReservation/{id}")
	public ResponseEntity<Reservation> deleteReservationController(@PathVariable("id") Integer reservationId,@RequestParam(required = false) String uuid ) throws ReservationException, BusException, UserException{
		
		Reservation deletedReservation = reservationService.deleteReservation(reservationId,uuid);
			
		return new ResponseEntity<Reservation>(deletedReservation,HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/viewReservation/{id}")
	public ResponseEntity<Reservation> viewReservationController(@PathVariable("id") Integer reservationId, @RequestParam(required = false) String uuid) throws ReservationException
	, UserException{
		
		Reservation getReservation = reservationService.viewReservation(reservationId,uuid);
		
		return new ResponseEntity<Reservation>(getReservation,HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/viewAllReservation")
	public ResponseEntity<List<Reservation>> viewAllReservationController(@RequestParam(required = false) String uuid) throws ReservationException{
		
		List<Reservation> reservationList = reservationService.viewAllReservation(uuid);
		
		return new ResponseEntity<List<Reservation>>(reservationList,HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/getByDate/{date}")
	public ResponseEntity<List<Reservation>>  getByDateController(@PathVariable("date") LocalDate date ) throws ReservationException{
		
		List<Reservation> lists = reservationService.getAllReservation(date);
		
		return new ResponseEntity<List<Reservation>>(lists,HttpStatus.ACCEPTED);
		
	}
	
}
