package com.example.aviation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private static final int PASSWORD_MINIMUM_CHARACTERS = 3;
    @Email(message = "Invalid email", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotBlank(message = "Invalid password!")
    @Size(min = PASSWORD_MINIMUM_CHARACTERS, message = "Password must be at least 3 characters!")
    private String password;

    @NotBlank(message = "Invalid password!")
    @Size(min = PASSWORD_MINIMUM_CHARACTERS, message = "Password must be at least 3 characters!")
    private String cpassword;
}
