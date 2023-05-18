package com.example.aviation.controller;

import com.example.aviation.domain.User;
import com.example.aviation.dto.*;
import com.example.aviation.exception.*;
import com.example.aviation.service.UserService;
import com.example.aviation.validation.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

//    @GetMapping("/home")
//    public String showUser(){
//        return "application work";
//    }
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest) throws UserRegistrationException {
        Validation.validateUserPassword(registerRequest.getPassword(), registerRequest.getCpassword());
        UserDTO createUser = userService.register(registerRequest);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid LoginDTO user) throws UserException, InvalidPasswordException, NoEmailException, NotLoggedInException {
        User u = userService.login(user);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.OK.value(), "Log in successful!"), HttpStatus.OK);
    }
}
