package com.onlinebusadda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebusadda.exception.RoutesException;
import com.onlinebusadda.model.Route;
import com.onlinebusadda.service.RouteService;

@RestController
public class RouteControllers {
	
	@Autowired 
	private RouteService routes;

    @PostMapping("/addRoute")
    public ResponseEntity<Route> addsRoot(@RequestBody Route rout) throws RoutesException {
        Route root = routes.addRoute(rout);
        return new ResponseEntity<Route>(root, HttpStatus.ACCEPTED);
    }
    
    
    
    @PutMapping("/updateRoutbyid/{id}")
    public ResponseEntity<Route> update(@RequestBody Route route) throws RoutesException {

        Route updatedRouteDetails = routes.updateRoute(route);
        return new ResponseEntity<Route>(updatedRouteDetails,HttpStatus.ACCEPTED);
    }

    
    
    @DeleteMapping("/deleteRoutbyid/{id}")
    public ResponseEntity<Route> delete(@PathVariable("id")Integer id) throws RoutesException {
        Route ro = routes.deleteRoute(id);
        return new ResponseEntity<>(ro,HttpStatus.OK);
    }
    
    @GetMapping("/viewRoutebyid/{id}")
    public ResponseEntity<Route> viewsbyid(@PathVariable("id")Integer id) throws RoutesException {
        Route root = routes.viewRoute(id);
        return new ResponseEntity<Route>(root,HttpStatus.OK);
    }
    
   
    @GetMapping("/viewAllroute")
    public ResponseEntity<List<Route>> viewAllHandler(@RequestParam Integer id) throws RoutesException{
        List<Route> list = routes.viewallRoute(id);
        return new ResponseEntity<List<Route>>(list,HttpStatus.ACCEPTED);
    }
}
