package com.example.aviation.controller;

import com.example.aviation.domain.User;
import com.example.aviation.dto.CreateDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.UserRegistrationException;
import com.example.aviation.service.UserService;
import com.example.aviation.validation.Validation;
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
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateDTO> register(@RequestBody @Valid UserDTO user) throws UserRegistrationException {
        Validation.validateUserPassword(user.getPassword(), user.getCpassword());
        Long newUserId = userService.register(user);
        return new ResponseEntity<CreateDTO>(new CreateDTO(HttpStatus.CREATED.value(), "User registered successfully!", newUserId), HttpStatus.CREATED);
    }
//------------Folosit doar pentru testare Spring Security --------------
//    @GetMapping("/users")
//    public ResponseEntity<List<User>>getUsers(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }
}
