//package com.example.aviation.utility;
//
//import com.example.aviation.domain.User;
//import com.example.aviation.repo.RoleRepo;
//import com.example.aviation.repo.UserRepo;
//import com.example.aviation.service.RoleService;
//import com.example.aviation.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//
//@Component
//public class OperationUtility implements CommandLineRunner {
//
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        createRoles();
//        createUsers();
//    }
//
//    private void createRoles() {
//        Arrays.asList("Admin", "User").forEach(role -> roleService.createRole(role));
//    }
//
//    private void createUsers(){
//        userService.createUser("test@test.com","12345","12345");
//        userService.assingRoleToUser("test@test.com","Admin");
//    }
//
//}
