package com.example.aviation.controller;


import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import com.example.aviation.dto.FlightsDTO;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.ResponseDTO;
import com.example.aviation.exception.InvalidPasswordException;
import com.example.aviation.exception.NoEmailException;
import com.example.aviation.exception.NotLoggedInException;
import com.example.aviation.exception.UserException;
import com.example.aviation.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightsController {

    @Autowired
    FlightsService flightsService;


    @GetMapping("/find/{leavingfrom}/{arrivingat}/{leavingdate}")
    public List<Flights> getFlights(@PathVariable String leavingfrom, @PathVariable String arrivingat, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date leavingdate, Integer nrseats, Date hrs) {
        return flightsService.findeAllFlightsAfterLeaving(leavingfrom, arrivingat, leavingdate,nrseats,hrs);
    }

    @GetMapping("/all-flights")
    public List<Flights> getAllBooks(){
        return this.flightsService.findeAllFlights();
    }
}