package com.onlinebusadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinebusadda.model.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
