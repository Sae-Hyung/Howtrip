package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend24.howtrip.member.service.MemberService;
import com.backend24.howtrip.member.vo.MemberVO;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public void loginPageGet() {
		
		logger.info("로그인 기능 수행");
	}
}
