package com.onlinebusadda.service;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.model.Bus;

import java.util.List;

public interface BusService {

    public Bus addBus(Bus bus) throws BusException;
    public Bus updateBus(Bus bus) throws BusException;
    public Bus deleteBus(int busId) throws BusException;
    public Bus viewBus(int busId) throws BusException;
    public List<Bus> viewBusByType(String busType) throws BusException;
    public List<Bus> viewAllBus() throws BusException;
}
