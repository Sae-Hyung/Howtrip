package com.backend24.howtrip.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPageGet() {
		
		logger.info("메인 페이지 진입");
		
		
		return "index";
	}
}