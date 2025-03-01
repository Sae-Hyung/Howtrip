package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindPwController {
	private static final Logger logger = LoggerFactory.getLogger(FindPwController.class);
	
	@RequestMapping(value = "/member/findPw.do", method = RequestMethod.GET)
	public void findPwdPageGet() {
		
		logger.info("비밀번호 찾기 페이지 진입");
	}
}