//package com.example.aviation.controller;
//
//
//import com.example.aviation.domain.Role;
//import com.example.aviation.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RoleController {
//
//    @Autowired
//    RoleService roleService;
//
//    @PostMapping({"/createNewRole"})
//        public Role createNewRole(@RequestBody Role role){
//            return roleService.createNewRole(role);
//        }
//}
