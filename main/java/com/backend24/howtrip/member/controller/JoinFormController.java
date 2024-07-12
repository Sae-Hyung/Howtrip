package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinFormController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinFormController.class);
	
	@RequestMapping(value = "/member/joinForm.do", method = RequestMethod.GET)
	public void loginPageGet() {
		logger.info("회원가입 페이지 진입");
	}
}
