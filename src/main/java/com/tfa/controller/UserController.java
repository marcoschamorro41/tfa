package com.tfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/usuarios", method = RequestMethod.GET)
    public String showUserPage(ModelMap model){
        return "usuarios";
    }

    @RequestMapping(value="/usercreation", method = RequestMethod.GET)
    public String showCrearUsuarioPage(ModelMap model) {
        return "crear-usuario";
    }

    @RequestMapping(value="/creationofuser", method = RequestMethod.POST)
    public String showMesajeExitoUsuarioCreado (ModelMap model, @RequestParam String username,
            @RequestParam String password, @RequestParam String corporate, @RequestParam String usertype) {
        model.put("username", username);
        return "usuario-creado";
    }

}
