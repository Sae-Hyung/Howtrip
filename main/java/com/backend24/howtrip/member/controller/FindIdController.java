package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindIdController {
	private static final Logger logger = LoggerFactory.getLogger(FindIdController.class);
	
	@RequestMapping(value = "/member/findId.do", method = RequestMethod.GET)
	public void findIdPageGet() {
		
		logger.info("아이디 찾기 페이지 진입");
	}
}
