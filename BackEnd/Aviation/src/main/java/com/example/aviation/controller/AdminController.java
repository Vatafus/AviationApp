package com.example.aviation.controller;


import com.example.aviation.domain.Flights;
import com.example.aviation.dto.FlightsDTO;
import com.example.aviation.repo.FlightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    FlightsRepo flightsRepo;


    @PostMapping("/create/flight")
    public Flights createFlight(@RequestBody Flights flights){
        return flightsRepo.save(flights);
    }


    @PutMapping("/update/flight/{id}")
    public ResponseEntity<Flights> updateFlights(@PathVariable Long id, @RequestBody Flights flightsDetails){
        Flights flights = flightsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight does not exist with id" + id));
        flights.setLeavingfrom(flightsDetails.getLeavingfrom());
        flights.setArrivingat(flightsDetails.getArrivingat());
        flights.setNrseats(flightsDetails.getNrseats());
        flights.setLeavingdate(flightsDetails.getLeavingdate());
        flights.setHrs(flightsDetails.getHrs());

        Flights updateFlight = flightsRepo.save(flights);
        return ResponseEntity.ok(updateFlight);
    }

    @DeleteMapping("/delete/flight/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteFlight(@PathVariable Long id){
        Flights flights = flightsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight not exist with id" + id));
        flightsRepo.delete(flights);
        Map<String,Boolean>response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
