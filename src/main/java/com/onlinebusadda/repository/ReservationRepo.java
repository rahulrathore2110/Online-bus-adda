package com.onlinebusadda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinebusadda.model.Reservation;


// This is a Data Access Layer class, which contains the data access logic
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

	@Query("SELECT r FROM Reservation r WHERE r.reservationDate =:reservationDate")
	public List<Reservation> findByReservationDate(@Param("reservationDate") LocalDate reservationDate);
	
}
