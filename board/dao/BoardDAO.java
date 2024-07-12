package com.backend24.howtrip.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.board.vo.BoardFileVO;
import com.backend24.howtrip.board.vo.BoardTagVO;
import com.backend24.howtrip.board.vo.BoardVO;
import com.backend24.howtrip.board.vo.CommentVO;

public interface BoardDAO {
	
	//게시판
    public List<BoardVO> selectAllBoards() throws DataAccessException;
    public BoardVO selectBoardById(int boardId) throws DataAccessException;
    public int insertBoard(BoardVO boardVO) throws DataAccessException;
    public int updateBoard(BoardVO boardVO) throws DataAccessException;
    public int deleteBoard(int boardId) throws DataAccessException;
    public int updateViews(int boardId) throws DataAccessException;
    public int updateLikeCnt(int boardId) throws DataAccessException;
    public int getLikeCnt(int boardId) throws DataAccessException;
    
    //첨부파일
    public List<BoardFileVO> selectFilesByBoardId(int boardId) throws DataAccessException;
    public int insertFile(BoardFileVO boardFileVO) throws DataAccessException;
    public int updateFile(BoardFileVO boardFileVO) throws DataAccessException;
    public int deleteFile(int fileId) throws DataAccessException;
    
    //댓글
    public List<CommentVO> selectCommentsByBoardId(int boardId) throws DataAccessException;
    public CommentVO selectCommentById(int commentId) throws DataAccessException;
    public int insertComment(CommentVO commentVO) throws DataAccessException;
    public int updateComment(CommentVO commentVO) throws DataAccessException;
    public int deleteComment(int commentId) throws DataAccessException;
    
    //태그
    public List<BoardTagVO> selectTagsByBoardId(int boardId) throws DataAccessException;
    public int insertTag(BoardTagVO boardTagVO) throws DataAccessException;
    public int deleteTag(int tagId) throws DataAccessException;
    
}