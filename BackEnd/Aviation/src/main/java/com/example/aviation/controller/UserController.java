package com.example.aviation.controller;

import com.example.aviation.domain.User;
import com.example.aviation.dto.CreateDTO;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.ResponseDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.*;
import com.example.aviation.service.UserService;
import com.example.aviation.validation.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @GetMapping("/home")
    public String showUser(){
        return "application work";
    }
//    @Autowired
//    private UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<CreateDTO> register(@RequestBody @Valid UserDTO user) throws UserRegistrationException {
//        Validation.validateUserPassword(user.getPassword(), user.getCpassword());
//        Long newUserId = userService.register(user);
//        return new ResponseEntity<CreateDTO>(new CreateDTO(HttpStatus.CREATED.value(), "User registered successfully!", newUserId), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid LoginDTO user) throws UserException, InvalidPasswordException, NoEmailException, NotLoggedInException {
//        User u = userService.login(user);
//        return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.OK.value(), "Log in successful!"), HttpStatus.OK);
//    }
}
