package com.tfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfa.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/usuarios", method = RequestMethod.GET)
    public String showUserPage(ModelMap model){
        return "usuarios";
    }

}
