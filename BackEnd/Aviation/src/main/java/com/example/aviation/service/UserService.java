package com.example.aviation.service;

import com.example.aviation.domain.User;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.InvalidPasswordException;
import com.example.aviation.exception.NotLoggedInException;

import com.example.aviation.exception.UserRegistrationException;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


//    User loadUserByEmail(String email);
//
//    User createUser(String email, String password, String cpassword);
//
//    void assignRoleToUser(String email, String roleName);
//
//    Long register(UserDTO u) throws UserRegistrationException;
//
//
//    User login(LoginDTO user) throws InvalidPasswordException, NotLoggedInException;


    private final UserRepo userRepo;

//    private RoleRepo roleRepo;

//    private PasswordEncoder passwordEncoder;

//    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
////        this.passwordEncoder = passwordEncoder;
//    }

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public User loadUserByEmail(String email){
//        return userRepo.findUserByEmail(email);
//    }


    public boolean isThereAlreadySuchEmail(String email) {
        User user = userRepo.findUserByEmail(email);
        return (user != null);
    }

//    public User createUser(String email, String password,String cpassword){
//        return userRepo.save(new User(email,password,cpassword));
//    }

    @Transactional
    public Long register(UserDTO u) throws UserRegistrationException {
        if (this.isThereAlreadySuchEmail(u.getEmail())) {
            throw new UserRegistrationException("Already Such email!");
        }
//        String encodedPassword = passwordEncoder.encode(u.getPassword());
//        String encodedCPassword = passwordEncoder.encode(u.getCpassword());
        User user = new User(u);
        userRepo.save(user);
        Long newUserId = userRepo.save(user).getId();
        return newUserId;
    }

//    public void assingRoleToUser(String email,String roleName){
//        User user = loadUserByEmail(email);
//        Role role = roleRepo.findByName(roleName);
//        user.assignRoleToUser(role);
//    }

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
