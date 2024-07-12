package com.backend24.howtrip.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.member.vo.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws DataAccessException ;
	public int deleteMember(String id) throws DataAccessException;
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	public int idCheck(MemberVO memberVO) throws DataAccessException;
}
