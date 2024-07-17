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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.backend24.howtrip.member.service.MemberService;
import com.backend24.howtrip.member.vo.MemberVO;


@Controller
@RequestMapping(value = "/member")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@ResponseBody
	@RequestMapping(value = "/checkLogin.do", method = RequestMethod.POST)
	public int login(RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result;
		
		// 입력 받은 아이디와 비밀번호의 값을 받아온다.
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 입력 받은 아이디와 비밀번호의 값을 확인하는 작업
		System.out.println("mebmerId : " + memberId);
		System.out.println("mebmerPw : " + memberPw);
		
		// memberId와 memberPw를 사용하여 회원정보가 데이터베이스에 있는지 검색하고 존재한다면 memberVO객체를 반환받는다. 존재하지않으면 memberVO객체는 null 값을 갖는다.
		memberVO = memberService.login(memberId, memberPw);
		
		// memberVO 객체와 memberVO 객체의 memberId 필드의 값을 확인한다.
		System.out.println("checkLogin() 메서드 - MemberVO객체의 값 : " + memberVO);
//		System.out.println("checkLogin() 메서드 - MemberVO.getMemeberId()의 값 : " + memberVO.getMemberId());
		
		if(memberVO == null) { // memberVO 객체가 존재하지 않으면 로그인 실패, result 값으로 0을 반환한다.
			rAttr.addAttribute("result","loginFailed");
		    
			result = 0;
		    System.out.println("LoginController : 로그인 실패");
		    System.out.println("LoginController : 로그인 창으로 이동");
		    
		    return result;
		    
		}else {// memberVO 객체가 존재하면 result 값으로 1을 반환한다.
			
			result = 1;			
			
		}
		
		return result;
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {// memberVO 객체가 존재하면 ajax를 이용해 login.do로 요청을 보낸다.
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
	    session.setAttribute("member", memberVO);
	    session.setAttribute("isLogOn", true);
	    
	    System.out.println("LoginController : 로그인 성공");
	    
	    mav.setViewName("redirect:/");
	    
	    // memberId의 값을 확인
	    System.out.println("login() 메서드 - memberVO.getMemberId()의 값 : " + memberVO.getMemberId());
	    return mav;
	}

}
