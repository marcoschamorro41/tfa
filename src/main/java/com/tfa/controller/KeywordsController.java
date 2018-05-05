package com.tfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.service.KeywordsService;

@Controller
public class KeywordsController {

    @Autowired
    KeywordsService keywordsService;

    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public String showKeywordsPage(ModelMap model){
        return "keywords";
    }

    @RequestMapping(value="/keywords", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String keyword, @RequestParam String limit){

        boolean isValidUser = keywordsService.isLimitValid(limit);

        if (!isValidUser) {
            model.put("errorMessage", "El limite debe ser un numero entre 0 y 500");
            return "keywords";
        }

        model.put("keyword", keyword);
        model.put("limit", limit);

        return "keywords";
    }

}