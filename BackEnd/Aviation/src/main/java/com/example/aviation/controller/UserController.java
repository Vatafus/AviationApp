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
    private UserDetailsServiceImpl userDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest) throws UserRegistrationException {
        Validation.validateUserPassword(registerRequest.getPassword(), registerRequest.getCpassword());
        UserDTO createUser = userService.register(registerRequest);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid LoginDTO user) throws UserException, InvalidPasswordException, NoEmailException, NotLoggedInException {
//        User u = userService.login(user);
//        return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.OK.value(), "Log in successful!"), HttpStatus.OK);
//    }


//    @PostMapping("/login")
//    public LoginDTOResponse createAuthenticationToken(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, ServletException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Incorrect username or password.");
//        } catch (DisabledException disabledException) {
//            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
//            return null;
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
//        User user = userRepo.findUserByEmail(loginDTO.getEmail());
//        final String jwt = jwtUtil.generateToken(loginDTO.getEmail());
//        return new LoginDTOResponse(jwt);
//    }
}
