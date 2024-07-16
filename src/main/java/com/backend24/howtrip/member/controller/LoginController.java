package com.backend24.howtrip.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.backend24.howtrip.member.service.MemberService;
import com.backend24.howtrip.member.vo.MemberVO;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);
		if(memberVO != null) {
			    HttpSession session = request.getSession();
			    session.setAttribute("member", memberVO);
			    session.setAttribute("isLogOn", true);
			    mav.setViewName("redirect:/");
			    
			    System.out.println("LoginController : 로그인 성공");
			    
		}else {
			    rAttr.addAttribute("result","loginFailed");
			    
			    System.out.println("LoginController : 로그인 실패");
			    System.out.println("LoginController : 로그인 창으로 이동");
			    
			    mav.setViewName("redirect:/member/loginForm.do");
			    
		}
		return mav;
	}
}
