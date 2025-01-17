package com.flight.adminManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.adminManagement.model.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
//    List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, LocalDate departureDate);
//  List<Flight> findBySourceAndDestination(String source, String destination);

}
