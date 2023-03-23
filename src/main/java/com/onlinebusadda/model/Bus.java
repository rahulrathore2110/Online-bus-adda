package com.onlinebusadda.model;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;


@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer busId;

    @NotNull(message = "Bus name cannot be null!")
    private String busName;

    @NotNull(message = "Bus driver name cannot be null!")
    private String driverName;

    @NotNull(message = "Bus type can not be null!")
    private String busType;


    @NotNull(message = "Start point cannot be null!")
    @NotBlank(message = "Start point cannot be blank!")
    private String routeFrom;

    @NotNull(message = "Destination point cannot be null!")
    @NotBlank(message = "Destination point cannot be blank!")
    private String routeTo;

    @NotNull(message = "Arrival time cannot be null!")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private LocalTime arrivalTime;

    @NotNull(message = "Arrival time cannot be null!")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private LocalTime departureTime;

    @NotNull(message = "seats should not be null")
    @Range(min=15,max=30, message = "Seats should be of between 15 to 30")
    private Integer seats;

    @NotNull(message = "seats should not be null")
    @Range(min=0,max=30, message = "Seats should be of between 0 to 30")
    private Integer availableSeats;

	@ManyToOne
	@JoinColumn(name = "route_FK")
	private Route route;

    public Bus() {
    }

    public Bus(Integer busId, String busName, String driverName, String busType, String routeFrom, String routeTo, LocalTime arrivalTime, LocalTime departureTime, Integer seats, Integer availableSeats, Route route) {
        this.busId = busId;
        this.busName = busName;
        this.driverName = driverName;
        this.busType = busType;
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.seats = seats;
        this.availableSeats = availableSeats;
        this.route = route;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(String routeFrom) {
        this.routeFrom = routeFrom;
    }

    public String getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(String routeTo) {
        this.routeTo = routeTo;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", busName='" + busName + '\'' +
                ", driverName='" + driverName + '\'' +
                ", busType='" + busType + '\'' +
                ", routeFrom='" + routeFrom + '\'' +
                ", routeTo='" + routeTo + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", seats=" + seats +
                ", availableSeats=" + availableSeats +
                ", route=" + route +
                '}';
    }
}