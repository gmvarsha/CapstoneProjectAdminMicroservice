package com.flight.adminManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.adminManagement.model.Flight;
import com.flight.adminManagement.repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Flight addFlight(Flight flight) {
        // Perform any validation or business logic here if needed
        return flightRepository.save(flight);
    }
    public boolean deleteFlight(Long id) {
    	Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            flightRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Flight updateFlight(Long id, Flight updatedFlight) {
    	System.out.println("Flight"+updatedFlight);
    	return flightRepository.findById(id).map(flight -> {
            flight.setFlightNumber(updatedFlight.getFlightNumber());
            flight.setSource(updatedFlight.getSource());
            flight.setDestination(updatedFlight.getDestination());
            flight.setDepartureDate(updatedFlight.getDepartureDate());
            flight.setDepartureTime(updatedFlight.getDepartureTime());
            flight.setArrivalDate(updatedFlight.getArrivalDate());
            flight.setArrivalTime(updatedFlight.getArrivalTime());
            flight.setPrice(updatedFlight.getPrice());
            return flightRepository.save(flight);
        }).orElse(null);
    }
    
}
