package com.backend24.howtrip.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.backend24.howtrip.member.vo.MemberVO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	


	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO findMember(Map member) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.findMember", member);
		return vo;
	}
	
	@Override
	public String checkPw(String memberId) throws DataAccessException {
		String memberPw = sqlSession.selectOne("mapper.member.checkPw", memberId);
		System.out.println("MemberDAOImple checkPw() 메서드 암호화된 memberPw의 값 : " + memberPw);
		return memberPw;
	}
	
	@Override
	public int checkId(String memberId) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.member.checkId", memberId);
		return result;
	}

}
