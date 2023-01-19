package com.onlinebusadda.serviceImpl;

import java.util.List;
import com.onlinebusadda.exception.*;
import com.onlinebusadda.model.*;

import org.springframework.stereotype.Service;

import com.example.demo.Route.Exception.RoutesException;
import com.example.demo.Route.Module.Route;
import com.onlinebusadda.service.RouteService;

@Service
public class RouteServiceimpl implements RouteService{

	@Override
	public Route addRoute(Route route) throws RoutesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route updateRoute(Route routes) throws RoutesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route deleteRoute(Integer Routeid) throws RoutesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route viewRoute(Integer rouInid) throws RoutesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> viewallRoute() throws RoutesException {
		// TODO Auto-generated method stub
		return null;
	}

}
