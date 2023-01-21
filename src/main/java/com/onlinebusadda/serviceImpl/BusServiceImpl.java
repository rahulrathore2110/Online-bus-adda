package com.onlinebusadda.serviceImpl;
import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.RoutesException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Bus;
import com.onlinebusadda.model.CurrentUserSession;
import com.onlinebusadda.repository.BusRepo;
import com.onlinebusadda.repository.CurrentUserSessionRepo;
import com.onlinebusadda.repository.RoutesRepo;
import com.onlinebusadda.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RoutesRepo routesRepo;

    private CurrentUserSessionRepo crepo;


    @Override
    public Bus addBus(Bus bus, String key) throws BusException, UserException {

        CurrentUserSession currentUserSession = crepo.findByUuid(key);

        if(currentUserSession == null){
            throw new UserException("Admin Not logged in");

        }

        if(currentUserSession.getUserType().equals("ADMIN")){

            busRepo.save(bus);
            return bus;

        }else{
            throw new UserException("Plz logged in as Admin");

        }


    }

    @Override
    public Bus updateBus(Bus bus, String key) throws BusException, AdminException, RoutesException {
        return null;
    }

    @Override
    public Bus deleteBus(int busId, String key) throws BusException, AdminException, RoutesException {
        return null;
    }

    @Override
    public Bus viewBus(int busId) throws BusException {


        Optional<Bus> opt = busRepo.findById(busId);
        if(opt.isPresent()) {
            Bus bus = opt.get();
            return bus;
        }
        else {
            throw new BusException("No Bus present with given id : "+busId);
        }
    }

    @Override
    public List<Bus> viewBusByType(String busType) throws BusException {
        List<Bus> buses =busRepo.findByBusType(busType);
        if(buses.size()>0) {
            return buses;
        }
        else {
            throw new BusException("No Buses present by given BusType : "+busType);
        }
    }

    @Override
    public List<Bus> viewAllBus() throws BusException {
        List<Bus> buses =busRepo.findAll();
        if(buses.size()>0) {
            return buses;
        }
        else {
            throw new BusException("No Buses present !!");
        }
    }
}
