package com.example.aviation.service;

import com.example.aviation.domain.User;
import com.example.aviation.domain.UserRole;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.RegisterRequest;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.InvalidPasswordException;
import com.example.aviation.exception.NotLoggedInException;

import com.example.aviation.exception.UserRegistrationException;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;


    public boolean isThereAlreadySuchEmail(String email) {
        User user = userRepo.findUserByEmail(email);
        return (user != null);
    }


//    @Transactional
//    public UserDTO register(RegisterRequest registerRequest) throws UserRegistrationException {
//        if (this.isThereAlreadySuchEmail(registerRequest.getEmail())) {
//            throw new UserRegistrationException("Already Such email!");
//        }
//        User user = new User(registerRequest.getEmail(), new BCryptPasswordEncoder().encode(registerRequest.getPassword()), new BCryptPasswordEncoder().encode(registerRequest.getCpassword()), UserRole.USER);
//        userRepo.save(user);
//        if(user==null){
//            return null;
//        }
//        return user.mapUsertoUserDto();
//    }

    public User getUserbyId(Long id){
        return userRepo.findById(id).get();
    }

    public UserDTO createUser(RegisterRequest registerRequest)throws UserRegistrationException {
        if (this.isThereAlreadySuchEmail(registerRequest.getEmail())) {
            throw new UserRegistrationException("Already Such email!");
        }
        if (!registerRequest.getPassword().equals(registerRequest.getCpassword())) {
            throw new UserRegistrationException("Password and Confirm Password do not match!");
        }
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        user.setCpassword(new BCryptPasswordEncoder().encode(registerRequest.getCpassword()));
        User createdUser = userRepo.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setUserRole(createdUser.getUserRole());
        return userDTO;
    }

    public boolean hasUserWithEmail(String email) {
        return userRepo.findUserByEmail(email) != null;
    }


//    public User login(LoginDTO user) throws InvalidPasswordException, NotLoggedInException{
//        User u = userRepo.findUserByEmail(user.getEmail());
//        if(u == null){
//            throw new NotLoggedInException("Invalid Email!");
//        }
//        if (!user.getPassword().equals(u.getPassword())){
//            throw new InvalidPasswordException("Invalid Password!");
//        }
//        return u;
//    }
}
