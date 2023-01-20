package com.onlinebusadda.repository;

import com.onlinebusadda.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepo extends JpaRepository<Bus,Integer> {

    public Bus findByDriverName(String driverName);

    public List<Bus> findByBusType(String busType);

    public List<Bus> findByRouteFromAndRouteTo(String routeFrom,String routeTo);
}
