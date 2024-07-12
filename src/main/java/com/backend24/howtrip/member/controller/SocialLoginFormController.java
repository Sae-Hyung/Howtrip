package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class SocialLoginFormController {
	
	private static final Logger logger = LoggerFactory.getLogger(SocialLoginFormController.class);
	
	//@RequestMapping(value = "/member/socialLoginForm.do", method = RequestMethod.GET)
	public void socialLoginPageGet() {
		
		logger.info("소셜 로그인 페이지 진입");
		
	}

}
