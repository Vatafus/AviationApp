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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightsController {

    @Autowired
    FlightsService flightsService;

    @GetMapping("/{leavingfrom}")
    public List<Flights> getFlights(@PathVariable String leavingfrom) {
        return flightsService.findeAllFlights(leavingfrom);
    }
}