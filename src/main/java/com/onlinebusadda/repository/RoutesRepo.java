package com.onlinebusadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebusadda.model.Route;

@RestControllerAdvice

public interface RoutesRepo extends JpaRepository<Route, Integer> {

}
