package com.backend24.howtrip.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.backend24.howtrip.member.dao.MemberDAO;
import com.backend24.howtrip.member.vo.MemberVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		String encodedPassword = passwordEncoder.encode(memberVO.getMemberPw());
		memberVO.setMemberPw(encodedPassword);
		
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(String memberId, String memberPw) throws Exception {
		Map member = new HashMap<String, String>();
		
		String encodedPassword = memberDAO.checkPw(memberId); // member 테이블에 저장되어 있는 memberId의 암호화된 memberPw 값을 가져온다.
		
		System.out.println("MemberServiceImple login() 메서드 passwordEncoder.matches 값 확인 : " + passwordEncoder.matches(memberPw, encodedPassword));
		
		if(encodedPassword == null) {
			encodedPassword = "";
		}
		
		if(passwordEncoder.matches(memberPw, encodedPassword)) { // 입력 받은 memberPw 값과 암호화된 memberPw의 값을 matches 메서드를 이용해서 비교
			member.put("memberId", memberId);
			member.put("memberPw", encodedPassword);
		} else {
			member.put("memberId", memberId);
			member.put("memberPw", "");
		}
		
		return memberDAO.findMember(member);
	}

//	@Override
//	public String checkPw(String memberId) throws DataAccessException {
//		return memberDAO.checkPw(memberId);
//	}

	@Override
	public int checkId(String memberId) throws DataAccessException {
		int result = memberDAO.checkId(memberId);
		return result;
	}

}
