package com.example.aviation.dto;


import com.example.aviation.domain.UserRole;
import com.example.aviation.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
@Email(message = "Invalid email", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    -Annotarea @Email ne ajuta in scrierea emailului acesta trebuie sa contina neaparat @ si sa contina si .com sau .ro sau . ceva
 */
@Data
public class UserDTO {

    private String email;


    private String password;


    private String cpassword;


    private UserRole userRole;



}
