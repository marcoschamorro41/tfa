package com.tfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.entities.Usuario;
import com.tfa.service.SearchService;
import com.tfa.service.UserService;

@Controller
public class SearchController {

	@Autowired
    SearchService seachService;

    // MOSTRADORES
    
    @RequestMapping(value="/busqueda", method = RequestMethod.GET)
    public String showSearchPage(ModelMap model){
        return "busqueda";
    }

    @RequestMapping(value="/resultados-busqueda", method = RequestMethod.GET)
    public String showSearchResultsPage(ModelMap model) {
        return "resultados-busqueda";
    }
    
}
