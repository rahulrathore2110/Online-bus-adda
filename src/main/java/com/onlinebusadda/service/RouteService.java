package com.onlinebusadda.service;
import com.onlinebusadda.model.*;
import com.onlinebusadda.exception.*;
import java.util.List;



public interface RouteService {
	
	public Route addRoute(Route route)throws RoutesException;
	public Route updateRoute(Route routes)throws RoutesException;
	public Route deleteRoute(Integer Routeid)throws RoutesException;
	public Route viewRoute(Integer rouInid)throws RoutesException;
	 public List<Route> viewallRoute() throws RoutesException;

}
