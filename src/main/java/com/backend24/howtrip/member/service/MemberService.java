package com.backend24.howtrip.member.service;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.member.vo.MemberVO;

public interface MemberService {
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws Exception;
	public int idCheck(MemberVO memberVO) throws DataAccessException;
}
