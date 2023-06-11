package com.example.aviation.domain;

public class RoleMapper {

    public static String GetRoleName(int databaseValue) {
        if (databaseValue == 0)
            return "ADMIN";

        if (databaseValue == 1)
            return "USER";

        return "";
    }
}
