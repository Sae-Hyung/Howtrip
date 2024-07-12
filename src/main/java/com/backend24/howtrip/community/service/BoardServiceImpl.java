package com.backend24.howtrip.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend24.howtrip.community.dao.BoardDAO;
import com.backend24.howtrip.community.vo.BoardVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> listBoards() throws DataAccessException {
        return boardDAO.selectAllBoards();
    }

    @Override
    public void addBoard(BoardVO boardVO) throws DataAccessException {
        boardDAO.insertBoard(boardVO);
    }

    @Override
    public void removeBoard(int boardId) throws DataAccessException {
        boardDAO.deleteBoard(boardId);
    }

    @Override
    public BoardVO viewBoard(int boardId) throws Exception {
        return boardDAO.selectBoardById(boardId);
    }

    @Override
    public void editBoard(BoardVO boardVO) throws DataAccessException {
        boardDAO.updateBoard(boardVO);
    }
}
