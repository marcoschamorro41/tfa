package com.tfa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.connectors.TwitterClient;
import com.tfa.service.KeywordsService;

@Controller
public class KeywordsController {

    @Autowired
    KeywordsService keywordsService;

    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public String showKeywordsPage(ModelMap model){
        return "keywords";
    }

    @RequestMapping(value="/addkeywords", method = RequestMethod.GET)
    public String showAddKeywordsPage(ModelMap model){
        return "agregar-keywords";
    }

    @RequestMapping(value="/creationofkeyword", method = RequestMethod.POST)
    public String showWelcomePage(HttpSession session, ModelMap model, @RequestParam String keyword, @RequestParam String limite){

        String empresa = (String) session.getAttribute("corporate");

        boolean isValidUser = keywordsService.isLimitValid(limite);

        if (!isValidUser) {
            model.put("errorMessage", "El limite debe ser un numero entre 0 y 100");
            return "keywords";
        }
        
        long limite1 = Long.parseLong(limite);
        TwitterClient.ingestContent(keyword, empresa, limite1);

        model.put("keyword", keyword);
        model.put("limite", limite1);
        model.put("corporate", empresa);

        return "keyword-agregado";
    }
    
    @RequestMapping(value="/searchkeywords", method = RequestMethod.GET)
    public String showSearchKeywordsPage(ModelMap model){
        return "buscar-keywords";
    }
    
    

}







