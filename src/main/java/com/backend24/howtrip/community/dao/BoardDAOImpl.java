package com.backend24.howtrip.community.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.backend24.howtrip.community.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

    @Autowired
       private SqlSession sqlSession;

       @Override
       public List selectAllBoards() throws DataAccessException {
           List<BoardVO> boardsList = null;
           boardsList = sqlSession.selectList("mapper.board.selectAllBoards");
           return boardsList;
       }

       @Override
       public BoardVO selectBoardById(int boardId) throws DataAccessException {
           BoardVO board = sqlSession.selectOne("mapper.board.selectBoardById", boardId);
           return board;
       }

       @Override
       public int insertBoard(BoardVO boardVO) throws DataAccessException {
           int result = sqlSession.insert("mapper.board.insertBoard", boardVO);
           return result;
       }

       @Override
       public int updateBoard(BoardVO boardVO) throws DataAccessException {
           int result = sqlSession.update("mapper.board.updateBoard", boardVO);
           return result;
       }

       @Override
       public int deleteBoard(int boardId) throws DataAccessException {
           int result = sqlSession.delete("mapper.board.deleteBoard", boardId);
           return result;
       }

       @Override
       public int updateViews(int boardId) throws DataAccessException {
           int result = sqlSession.update("mapper.board.updateViews", boardId);
           return result;
       }

       @Override
       public int updateLikeCnt(int boardId) throws DataAccessException {
           int result = sqlSession.update("mapper.board.updateLikeCnt", boardId);
           return result;
    }
}
