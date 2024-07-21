package com.example.adminManagement.controller;


import com.example.adminManagement.model.Flight;
import com.example.adminManagement.repository.FlightRepository;
import com.example.adminManagement.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:3000")

public class FlightController {

    @Autowired
    private FlightService flightService;
   
    @GetMapping("/getAllflights")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }
    
    @PostMapping("/addflight")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
		List<Flight> updatedFlights = flightService.getAllFlights(); // Fetch updated list of flights

        if (savedFlight != null) {

                return new ResponseEntity<>(updatedFlights, HttpStatus.CREATED);
        	 
        } else {
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);        }
    }
//    @PutMapping("/updateflight/{id}")
//    public ResponseEntity<String> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
//        Flight updatedFlight = flightService.updateFlight(id, flight);
//        if (updatedFlight != null) {
//            return ResponseEntity.ok("Flight updated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
//        }
//    }
    @PutMapping("/updateflight/{id}")
    public ResponseEntity<List<Flight>> updateFlight(@PathVariable Long id, @RequestBody Flight updatedFlight) {
        try {
            System.out.println(id);

            Flight flight = flightService.updateFlight(id, updatedFlight);
            if (flight != null) {
                List<Flight> updatedFlights = flightService.getAllFlights();
                return new ResponseEntity<>(updatedFlights, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteflight/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        System.out.println(id);

        boolean isRemoved = flightService.deleteFlight(id);
        if (!isRemoved) {
            return ResponseEntity.status(404).body("Flight not found");
        }
        return ResponseEntity.ok("Flight deleted successfully");
    }
}