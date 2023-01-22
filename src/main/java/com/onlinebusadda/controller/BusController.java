package com.onlinebusadda.controller;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.RoutesException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Bus;
import com.onlinebusadda.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService bService;

    @PostMapping("/buses/{routeid}")
    public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus, @RequestParam(required = false) String key,
                                      @PathVariable("routeid") Integer routeid) throws BusException, UserException, RoutesException {
        return new ResponseEntity<Bus>(bService.addBus(bus,key,routeid), HttpStatus.CREATED);
//		http://localhost:8888/buses     admin key
    }

    @PutMapping("/buses")
    public ResponseEntity<Bus> updateBus(@RequestBody Bus bus, @RequestParam(required = false) String key) throws BusException, UserException{
        return new ResponseEntity<Bus>(bService.updateBus(bus,key),HttpStatus.ACCEPTED);
//		http://localhost:8888/buses
    }

    @DeleteMapping("/buses/{busId}")
    public ResponseEntity<Bus> deleteBus(@PathVariable("busId") Integer Id,@RequestParam(required = false) String key) throws BusException, UserException{
        return new ResponseEntity<Bus>(bService.deleteBus(Id,key), HttpStatus.OK);
//		http://localhost:8888/buses/busID
    }

    @GetMapping("/buses/{busId}")
    public ResponseEntity<Bus> viewBusbyId(@PathVariable("busId") Integer Id) throws BusException{
        return new ResponseEntity<Bus>(bService.viewBus(Id), HttpStatus.ACCEPTED);
//		http://localhost:8888/buses/busID
    }

    @GetMapping("/busByType/{busType}")
    public ResponseEntity<List<Bus>> viewBusbyType(@PathVariable("busType") String type) throws BusException{
        return new ResponseEntity<List<Bus>>(bService.viewBusByType(type), HttpStatus.FOUND);
//		http://localhost:8888/busByType/busType
    }

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> viewAll() throws BusException{
        return new ResponseEntity<List<Bus>>(bService.viewAllBus(), HttpStatus.OK);
//		http://localhost:8888/buses
    }

}