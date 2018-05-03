package com.tfa.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        boolean correctUser = userid.equalsIgnoreCase("admin") ||
                userid.equalsIgnoreCase("chamo");
        boolean correctPass = password.equalsIgnoreCase("123");
        return correctUser && correctPass;
    }

    public boolean isAdmin(String userid) {
        return userid.equalsIgnoreCase("admin");
    }

}