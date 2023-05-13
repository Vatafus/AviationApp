//package com.example.aviation.service.impl;
//
//import com.example.aviation.domain.Role;
//import com.example.aviation.domain.User;
//import com.example.aviation.dto.LoginDTO;
//import com.example.aviation.dto.UserDTO;
//import com.example.aviation.exception.InvalidPasswordException;
//import com.example.aviation.exception.NotLoggedInException;
//import com.example.aviation.exception.UserRegistrationException;
//import com.example.aviation.repo.RoleRepo;
//import com.example.aviation.repo.UserRepo;
//import com.example.aviation.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//    private UserRepo userRepo;
//
//    private RoleRepo roleRepo;
//
//    private PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public User loadUserByEmail(String email) {
//        return userRepo.findUserByEmail(email);
//    }
//
//    @Override
//    public User createUser(String email, String password,String cpassword) {
//        String encodedPassword = passwordEncoder.encode(password);
//        String encodedCPassword = passwordEncoder.encode(cpassword);
//        return userRepo.save(new User(email, encodedPassword, encodedCPassword));
//    }
//
////
//    @Override
//    public void assignRoleToUser(String email, String roleName) {
//        User user = loadUserByEmail(email);
//        Role role = roleRepo.findByName(roleName);
//        user.assignRoleToUser(role);
//    }
//
//    @Override
//    public Long register(UserDTO u) throws UserRegistrationException {
//        if (this.isThereAlreadySuchEmail(u.getEmail())) {
//            throw new UserRegistrationException("Already Such email!");
//        }
//        User user = new User(u);
//        userRepo.save(user);
//        Long newUserId = userRepo.save(user).getId();
//        return newUserId;
//    }
//
//    public User login(LoginDTO user) throws InvalidPasswordException, NotLoggedInException {
//        User u = userRepo.findUserByEmail(user.getEmail());
//        if(u == null){
//            throw new NotLoggedInException("Invalid Email!");
//        }
//        if (!user.getPassword().equals(u.getPassword())){
//            throw new InvalidPasswordException("Invalid Password!");
//        }
//        return u;
//    }
//
//    public boolean isThereAlreadySuchEmail(String email) {
//        User user = userRepo.findUserByEmail(email);
//        return (user != null);
//    }
//
//}
