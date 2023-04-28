package com.example.aviation.service;

import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import com.example.aviation.dto.FlightsDTO;
import com.example.aviation.repo.FlightsRepo;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService {

    private final FlightsRepo flightsRepo;

    @Autowired
    public FlightsService(FlightsRepo flightsRepo) {
        this.flightsRepo = flightsRepo;
    }

//    public FlightsDTO findeFlight(String leavingfrom){
//        Flights flights = flightsRepo.findFlightsByleavingfrom(leavingfrom);
//        FlightsDTO flightsDTO = new FlightsDTO(flights);
//        return flightsDTO;
//    }

    public List<Flights> findeAllFlights() {
        return flightsRepo.findAll();
    }

    public List<Flights> findeAllFlightsAfterLeaving(String leavingfrom) {
        return flightsRepo.findFlightsByleavingfrom(leavingfrom);
    }
}
