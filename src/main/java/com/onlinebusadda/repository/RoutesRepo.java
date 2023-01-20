package com.onlinebusadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebusadda.model.Route;

@Repository
public interface RoutesRepo extends JpaRepository<Route, Integer> {

}
