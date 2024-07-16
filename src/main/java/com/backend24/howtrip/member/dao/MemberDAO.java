package com.backend24.howtrip.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.member.vo.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws DataAccessException ;
	public int deleteMember(String id) throws DataAccessException;
	public MemberVO findMember(Map member) throws DataAccessException;
	public String checkPw(String memberId) throws DataAccessException;
	public int checkId(String memberId) throws DataAccessException;
}
