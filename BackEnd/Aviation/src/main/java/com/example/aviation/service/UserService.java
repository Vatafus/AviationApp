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


    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    public boolean isThereAlreadySuchEmail(String email) {
        User user = userRepo.findUserByEmail(email);
        return (user != null);
    }


    @Transactional
    public UserDTO register(RegisterRequest registerRequest) throws UserRegistrationException {
        if (this.isThereAlreadySuchEmail(registerRequest.getEmail())) {
            throw new UserRegistrationException("Already Such email!");
        }
        User user = new User(registerRequest.getEmail(), new BCryptPasswordEncoder().encode(registerRequest.getPassword()), new BCryptPasswordEncoder().encode(registerRequest.getCpassword()), UserRole.USER);
        userRepo.save(user);
        if(user==null){
            return null;
        }
        return user.mapUsertoUserDto();
    }


    public User login(LoginDTO user) throws InvalidPasswordException, NotLoggedInException{
        User u = userRepo.findUserByEmail(user.getEmail());
        if(u == null){
            throw new NotLoggedInException("Invalid Email!");
        }
        if (!user.getPassword().equals(u.getPassword())){
            throw new InvalidPasswordException("Invalid Password!");
        }
        return u;
    }
}
