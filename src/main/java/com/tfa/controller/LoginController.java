package com.tfa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.connectors.MongoConnector;
import com.tfa.retriever.Tweet;
import com.tfa.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(HttpSession session, ModelMap model, @RequestParam String corporate, @RequestParam String name, @RequestParam String password) {
    	boolean isValidUser = service.validateUser(corporate, name, password);
        boolean isAdmin = service.isAdmin(name);        

        if (!isValidUser) {
            model.put("errorMessage", "Fallo al loguearse. Compruebe los datos");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        model.put("corporate", corporate);

        session.setAttribute("corporate", corporate);
        
        MongoConnector c = new MongoConnector();
        List<Tweet> list = c.obtenerTweetsDeMongo(corporate);
        
        for (Tweet tweet : list) {
			System.out.println("Usuario: " + tweet.getUsuario() + " - Hashtags: " + tweet.getListaHashtags());
		}
        
        if (isAdmin)
            return "admin";
        return "welcome";
    }
}