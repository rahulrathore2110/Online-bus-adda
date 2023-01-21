package com.onlinebusadda.service;
import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.RoutesException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Bus;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BusService {

    public Bus addBus(Bus bus,String key) throws BusException, UserException;
    public Bus updateBus(Bus bus,String key) throws BusException, RoutesException ;
    public Bus deleteBus(int busId,String key) throws BusException,RoutesException;
    public Bus viewBus(int busId) throws BusException;
    public List<Bus> viewBusByType(String busType) throws BusException;
    public List<Bus> viewAllBus() throws BusException;
}
