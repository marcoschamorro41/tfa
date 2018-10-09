package com.tfa.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String showAdminPage(HttpSession session, ModelMap model) {
        String empresa = (String) session.getAttribute("corporate");
        if (empresa != null && !StringUtils.isEmpty(empresa))
        	return "admin";
        return "login";
    }
    

}