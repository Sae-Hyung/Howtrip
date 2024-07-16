package com.backend24.howtrip.community.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.community.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> listBoards() throws DataAccessException;
	public void addBoard(BoardVO boardVO) throws DataAccessException;
	public void removeBoard(int boardId) throws DataAccessException;
	public BoardVO viewBoard(int boardId) throws Exception;
	public void editBoard(BoardVO boardVO) throws DataAccessException;
}
