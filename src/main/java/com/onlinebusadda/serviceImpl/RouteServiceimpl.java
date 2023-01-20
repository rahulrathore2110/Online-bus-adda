package com.onlinebusadda.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.onlinebusadda.exception.*;
import com.onlinebusadda.model.*;
import com.onlinebusadda.repository.RoutesRepo;
import com.onlinebusadda.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebusadda.service.RouteService;

@Service
public class RouteServiceimpl implements RouteService{
	@Autowired 
	private RoutesRepo routerepo;

	@Override
	public Route addRoute(Route route) throws RoutesException {
		// TODO Auto-generated method stub
		Route routes=routerepo.save(route);
		
		return routes;
	}

	@Override
	public Route updateRoute(Route routes) throws RoutesException {
		// TODO Auto-generated method stub
Optional<Route> opt= routerepo.findById(routes.getRouteid());
		
		if(opt.isPresent()) {
			
			Route existingRoute= opt.get();

			
			
			return  routerepo.save(routes);
			
			
		}else
			throw new RoutesException("Invalid Student :");
	}

	@Override
	public Route deleteRoute(Integer Routeid) throws RoutesException {
Optional<Route> opt= routerepo.findById(Routeid);
		
		if(opt.isPresent()) {
			
			Route rout= opt.get();
			
			routerepo.delete(rout);
			
			return  rout;
			
		}
		else
			throw new RoutesException("Student does not exist with roll :"+Routeid);
	}
	
	

	@Override
	public Route viewRoute(Integer rouInid) throws RoutesException {

        Optional<Route> opt =routerepo.findById(rouInid);

        if(opt.isPresent()) {

            return opt.get();
        }
        else {
            throw new RoutesException("No route found on this "+rouInid+" id");
        }
		
	}

	
	
	
	
	@Override
	public List<Route> viewallRoute(Integer Routeid) throws RoutesException {
		

		

        List<Route> routeList = routerepo.findAll();

        if(routeList.size()!=0) {

            return routeList;
        }else {
            throw new RoutesException("Route list is empty");
        }

    }

	}

	

	

	  

