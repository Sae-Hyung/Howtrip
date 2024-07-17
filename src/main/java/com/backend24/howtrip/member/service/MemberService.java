package com.backend24.howtrip.member.service;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.member.vo.MemberVO;

public interface MemberService {
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	public MemberVO login(String memberId, String memberPw) throws Exception;
//	public String checkPw(String memberId) throws DataAccessException;
	public int checkId(String memberId) throws DataAccessException;
}
