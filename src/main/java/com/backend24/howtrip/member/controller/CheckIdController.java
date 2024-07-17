package com.backend24.howtrip.member.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend24.howtrip.member.service.MemberService;
import com.backend24.howtrip.member.vo.MemberVO;

@Controller
public class CheckIdController {
	private static final Logger logger = LoggerFactory.getLogger(CheckIdController.class);
	
	@Autowired
	private MemberService memberService;
	
	
	
	// 아이디 중복 체크 작업 수행
	@ResponseBody // 이 어노테이션이 있어야 XML, JSON 파일을 브라우저로 전송할 수 있음
	@RequestMapping(value = "/member/checkId.do", method = RequestMethod.POST)
	public int idCheck(HttpServletRequest request, HttpServletResponse response) {
		
		int result;
		String memberId = request.getParameter("memberId"); // 특수문자가 포함되어 있을 수도 있는 문자열, userId
		String regex = "[^a-zA-Z0-9]"; // 영어와 숫자를 제외한 모든 문자, 정규 표현식
		
		Pattern pattern = Pattern.compile(regex); // 컴파일된 정규 표현식을 반환
		Matcher matcher = pattern.matcher(memberId); // 패턴에 대한 대상 문자열의 새로운 matcher를 반환
		
		if (memberId.length() < 6 || memberId.length() > 20) {
			System.out.println("userId 길이 검사");
			result = 2; // userId의 길이가 아이디 생성 규칙에 어긋난다면 result의 값을 2로 설정한다.
			return result;
		} else if (matcher.find()) { // 대상 문자열과 패턴이 일치하는 경우 true를 반환
			System.out.println("userId에 영어, 숫자 외의 문자가 포함되어 있는지 검사");
			result = 3; // userId에 특수문자가 존재한다면 result의 값을 3으로 설정한다.
			return result;
		}
		
		
		// member 테이블에 중복되는 userId가 존재하는지 검사하고 존재하면 result = 1, 존재하지 않으면 result = 0으로 설정
		result = memberService.checkId(memberId);  
		
		
		System.out.println("아이디 중복체크 작업 수행");
		return result;	// joinForm.jsp로 result값을 반환	
	}

}
