//package com.example.aviation.controller;
//
//import com.example.aviation.domain.User;
//import com.example.aviation.dto.LoginDTO;
//import com.example.aviation.dto.LoginDTOResponse;
//import com.example.aviation.repo.UserRepo;
//import com.example.aviation.service.UserService;
//import com.example.aviation.utility.JwtUtil;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/authenticate")
//    public LoginDTOResponse createAuthenticationToken(@RequestBody LoginDTO authenticationRequest, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Incorrect username or password.");
//        } catch (DisabledException disabledException) {
//            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User is not activated");
//            return null;
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        User user = userRepo.findUserByEmail(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(authenticationRequest.getUsername());
//        return new LoginDTOResponse(jwt);
//    }
//}
