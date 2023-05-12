package com.example.aviation.utility;

import com.example.aviation.domain.User;
import com.example.aviation.repo.UserRepo;
import com.example.aviation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class OperationUtility implements CommandLineRunner {


    @Autowired
    public static UserService userService;

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    private void createUsers(){
        userService.createUser(1L,"test@test.com","12345","12345");
    }

}
