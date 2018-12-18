package com.tfa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfa.connectors.MongoConnector;
import com.tfa.retriever.Tweet;

import akka.dispatch.Foreach;

@Controller
public class ReportsController {

    // MOSTRADORES
    
    @RequestMapping(value="/reportes", method = RequestMethod.GET)
    public String showReportPage(ModelMap model){
    	MongoConnector mongoConn = new MongoConnector();
    	List<Tweet> result = mongoConn.obtenerTweetsDeMongo((System.getProperty("company")));
    	int cantRetweets = 0;
    	int cantLikes  = 0;
    	for (Tweet tweet : result) {
			cantRetweets += tweet.getCantidadRetweet();
			cantLikes += tweet.getCantidadFavoritos();
		}
    	
    	int cantArg = mongoConn.obtenerCantPAISDeMongo((System.getProperty("company")), "ARG");
    	int cantBra = mongoConn.obtenerCantPAISDeMongo((System.getProperty("company")), "BRA");
    	int cantUsa = mongoConn.obtenerCantPAISDeMongo((System.getProperty("company")), "USA");
    			
    	model.addAttribute("cantretweets", cantRetweets);
    	model.addAttribute("cantrelikes", cantLikes);
    	model.addAttribute("cantArg", cantArg);
    	model.addAttribute("cantBra", cantBra);
    	model.addAttribute("cantUsa", cantUsa);
    	
    	mongoConn.mencionesFecha(System.getProperty("company"));
        return "reportes";
    }


}
