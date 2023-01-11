package com.example.aviation.service;

import com.example.aviation.domain.User;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.InvalidPasswordException;
import com.example.aviation.exception.NotLoggedInException;
import com.example.aviation.exception.UserRegistrationException;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Long register(UserDTO u) throws UserRegistrationException {
        if (this.isThereAlreadySuchEmail(u.getEmail())) {
            throw new UserRegistrationException("Already Such email!");
        }
        User user = new User(u);
        userRepo.save(user);
        Long newUserId = userRepo.save(user).getId();
        return newUserId;
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


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
// -------------Folosit pentru testare Spring Security--------------
//    public List<User> getUsers(){
//        return userRepo.findAll();
//    }
}
