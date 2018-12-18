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
import com.tfa.service.SearchService;

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
        boolean isOperador = service.isOperador(name);  

        if (!isValidUser) {
            model.put("errorMessage", "Fallo al loguearse. Compruebe los datos");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        model.put("corporate", corporate);
        session.setAttribute("corporate", corporate);
        /**
        MongoConnector c = new MongoConnector();
        
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
        
        System.out.println("TEST 1: TODOS");
        List<Tweet> list1 = sservice.getTweets(corporate, false, "", false, "", "NONE");
        System.out.println("Cantidad de tweets: " + list1.size());
        
        System.out.println("\nTEST 2: hate the left");
        List<Tweet> list2 = sservice.getTweets(corporate, false, "hate the left", false, "", "NONE");
        System.out.println("Cantidad de tweets: " + list2.size());
        
        System.out.println("\nTEST 3: NOT(hate the left)");
        List<Tweet> list3 = sservice.getTweets(corporate, true, "hate the left", false, "", "NONE");
        System.out.println("Cantidad de tweets: " + list3.size());
        
        System.out.println("\nTEST 4: hate the left AND picho");
        List<Tweet> list4 = sservice.getTweets(corporate, false, "hate the left", false, "picho", "AND");
        System.out.println("Cantidad de tweets: " + list4.size());
        
        System.out.println("\nTEST 5: misinformati AND hate the left");
        List<Tweet> list5 = sservice.getTweets(corporate, false, "misinformati", false, "hate the left", "AND");
        System.out.println("Cantidad de tweets: " + list5.size());
        
        System.out.println("\nTEST 6: hate the left OR hate the left");
        List<Tweet> list6 = sservice.getTweets(corporate, false, "hate the left", false, "Democrats backed", "OR");
        System.out.println("Cantidad de tweets: " + list6.size());
        
//        for (Tweet tweet : list) {
//			System.out.println("Usuario: " + tweet.getUsuario() + " - Hashtags: " + tweet.getListaHashtags());
//		}
        
        List<Tweet> list = sservice.getTweets(corporate, false, "", false, "", "NONE");
        
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
        System.out.println("TESTING SEARCHING FEATURE");
         */
        
        if (isAdmin)
            return "admin";
        if(isOperador)
        	return "operador";
        return "welcome";
    }
}