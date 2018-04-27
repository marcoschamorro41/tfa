	package com.tfa.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class SearchKeywordsController {

	   @RequestMapping("/search-keywords")
	   public String searchKeywords() {
	      return "keywords";
	   }

	  
	}