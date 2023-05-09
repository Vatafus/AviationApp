package com.example.aviation.service;

import com.example.aviation.domain.Role;
import com.example.aviation.domain.User;
import com.example.aviation.dto.LoginDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.InvalidPasswordException;
import com.example.aviation.exception.NotLoggedInException;
import com.example.aviation.exception.UserRegistrationException;
import com.example.aviation.repo.RoleRepo;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public RoleRepo roleRepo;

    public void initRoleAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin user");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User user");
        roleRepo.save(userRole);

        User adminUser = new User();
        adminUser.setEmail("admin@flybird.com");
        adminUser.setPassword("admin");
        adminUser.setCpassword("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        userRepo.save(adminUser);

        User user = new User();
        user.setEmail("user@flybird.com");
        user.setPassword("12345");
        adminUser.setCpassword("12345");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        userRepo.save(user);
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
