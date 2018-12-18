package com.tfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.connectors.MongoConnector;
import com.tfa.entities.Usuario;
import com.tfa.retriever.Tweet;
import com.tfa.service.SearchService;
import com.tfa.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class SearchController {

	@Autowired
    SearchService seachService;

    // MOSTRADORES
    
    @RequestMapping(value="/busqueda", method = RequestMethod.GET)
    public String showSearchPage(ModelMap model){
        return "busqueda";
    }

    @RequestMapping(value="/resultados-busqueda", method = RequestMethod.POST)
    public String showSearchResultsPage(ModelMap model,  @RequestParam String primerabus,
            @RequestParam String segundabus, @RequestParam String operator, @RequestParam String titleNot , @RequestParam String bodyNot) {
       boolean bandtitle = true;
       boolean bandbody = true;
    	if (titleNot.equals("not")){
    		bandtitle = false;
        }
    	if (bodyNot.equals("not")){
    		bandtitle = false;
        }
        System.out.print(bodyNot);
    	MongoConnector mongoConn = new MongoConnector();
    	List<Tweet> result = mongoConn.obtenerTweetsDeMongo(System.getProperty("company"), primerabus, segundabus, operator);
    	//List<Tweet> result = seachService.getTweets(System.getProperty("company"), bandtitle, primerabus, bandbody, segundabus, operator);
    	model.addAttribute("tweets", result);
    	return "resultados-busqueda";
    }
    
}
