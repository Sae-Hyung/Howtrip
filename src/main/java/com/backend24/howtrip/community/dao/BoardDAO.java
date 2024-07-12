package com.backend24.howtrip.community.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.community.vo.BoardVO;

public interface BoardDAO {
	public List selectAllBoards() throws DataAccessException;
	public BoardVO selectBoardById(int boardId) throws DataAccessException;
	public int insertBoard(BoardVO boardVO) throws DataAccessException;
	public int updateBoard(BoardVO boardVO) throws DataAccessException;
	public int deleteBoard(int boardId) throws DataAccessException;
	public int updateViews(int boardId) throws DataAccessException;
	public int updateLikeCnt(int boardId) throws DataAccessException;
}
