package com.example.aviation.controller;

import com.example.aviation.domain.User;
import com.example.aviation.dto.*;
import com.example.aviation.exception.*;
import com.example.aviation.repo.UserRepo;
import com.example.aviation.service.UserDetailsServiceImpl;
import com.example.aviation.service.UserService;
import com.example.aviation.utility.JwtUtil;
import com.example.aviation.validation.Validation;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;
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

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest) throws UserRegistrationException {
//        Validation.validateUserPassword(registerRequest.getPassword(), registerRequest.getCpassword());
//        UserDTO createUser = userService.register(registerRequest);
//        return new ResponseEntity<>(createUser,HttpStatus.OK);
//    }


    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody RegisterRequest registerRequest) {

        if(userService.hasUserWithEmail(registerRequest.getEmail())){
            return new ResponseEntity<>("User already exist",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDTO createdUser = userService.createUser(registerRequest);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created. Come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid LoginDTO user) throws UserException, InvalidPasswordException, NoEmailException, NotLoggedInException {
//        User u = userService.login(user);
//        return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.OK.value(), "Log in successful!"), HttpStatus.OK);
//    }


    @PostMapping("/login")
    public LoginDTOResponse createAuthenticationToken(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, ServletException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
        User user = userRepo.findUserByEmail(loginDTO.getUsername());
        final String jwt = jwtUtil.generateToken(loginDTO.getUsername());
        return new LoginDTOResponse(jwt);
    }
}
