package com.example.aviation.validation;

import com.example.aviation.exception.UserRegistrationException;

public class Validation {

    private static final String USER_ATTRIBUTE = "user";

    public static void validateUserPassword(String password, String cpassword) throws UserRegistrationException {
        if (!cpassword.equals(password)) {
            throw new UserRegistrationException("Invalid password!");
        }
    }
}
