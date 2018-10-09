package com.tfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportsController {

    // MOSTRADORES
    
    @RequestMapping(value="/reportes", method = RequestMethod.GET)
    public String showReportPage(ModelMap model){
        return "reportes";
    }


}
