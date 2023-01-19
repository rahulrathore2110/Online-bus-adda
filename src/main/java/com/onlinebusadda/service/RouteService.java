package com.onlinebusadda.service;

import java.util.List;

import com.example.demo.Route.Exception.RoutesException;
import com.example.demo.Route.Module.Route;


public interface RouteService {
	
	public Route addRoute(Route route)throws RoutesException;
	public Route updateRoute(Route routes)throws RoutesException;
	public Route deleteRoute(Integer Routeid)throws RoutesException;
	public Route viewRoute(Integer rouInid)throws RoutesException;
	 public List<Route> viewallRoute() throws RoutesException;

}
