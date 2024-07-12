package com.backend24.howtrip.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend24.howtrip.member.service.MemberService;
import com.backend24.howtrip.member.vo.MemberVO;

@Controller
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO ;
	
	@RequestMapping(value="/member/join.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		System.out.println(result);
		ModelAndView mav = new ModelAndView("redirect:/member/loginForm.do");
		return mav;
	}
			
}
