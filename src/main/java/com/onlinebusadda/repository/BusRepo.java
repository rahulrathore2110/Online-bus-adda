package com.onlinebusadda.repository;

import com.onlinebusadda.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus,Integer> {

    public Bus findByDriverName(String driverName);

    public List<Bus> findByBusType(String busType);

    public List<Bus> findByRouteFromAndRouteTo(String routeFrom,String routeTo);
}
