package com.onlinebusadda.repository;

import com.onlinebusadda.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus,Integer> {
}
