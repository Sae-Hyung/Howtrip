package com.backend24.howtrip.community.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.backend24.howtrip.community.vo.BoardFileVO;
import com.backend24.howtrip.community.vo.BoardTagVO;
import com.backend24.howtrip.community.vo.BoardVO;
import com.backend24.howtrip.community.vo.CommentVO;

public interface BoardService {
	// 기본 게시판 관련 메서드
    public int insertBoard(BoardVO boardVO) throws DataAccessException;
    public int removeBoard(int boardId) throws DataAccessException;
    public BoardVO viewBoard(int boardId) throws DataAccessException;
    public List<BoardVO> getAllBoards() throws DataAccessException;
    public int updateBoard(BoardVO boardVO) throws DataAccessException;
    public int deleteBoard(int boardId) throws DataAccessException;
    public void incrementLikeCnt(int boardId) throws DataAccessException;
    public int getLikeCnt(int boardId) throws DataAccessException;
    public BoardVO findByBoardId(int boardId) throws DataAccessException;
    
    // 첨부파일 관련 메서드
    public List<BoardFileVO> getFilesByBoardId(int boardId) throws DataAccessException;
    public int addFile(BoardFileVO boardFileVO) throws DataAccessException;
    public int updateFile(BoardFileVO boardFileVO) throws DataAccessException;
    public int deleteFile(int fileId) throws DataAccessException;
    
    // 댓글 관련 메서드
    public List<CommentVO> getCommentsByBoardId(int boardId) throws DataAccessException;
    public CommentVO getCommentById(int commentId) throws DataAccessException;
    public int addComment(CommentVO commentVO) throws DataAccessException;
    public int updateComment(CommentVO commentVO) throws DataAccessException;
    public int deleteComment(int commentId) throws DataAccessException;

    // 태그 관련 메서드
    public List<BoardTagVO> getTagsByBoardId(int boardId) throws DataAccessException;
    public int addTag(BoardTagVO boardTagVO) throws DataAccessException;
    public int deleteTag(int tagId) throws DataAccessException;
}
