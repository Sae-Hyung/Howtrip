package com.backend24.howtrip.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CertificationController {
	private static final Logger logger = LoggerFactory.getLogger(CertificationController.class);
	
	@RequestMapping(value = "/member/certification", method = RequestMethod.GET)
	public void certificationPageGet() {
		
		logger.info("본인인증 페이지 진입");
	}
}
