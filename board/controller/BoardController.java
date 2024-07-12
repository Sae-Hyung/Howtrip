package com.backend24.howtrip.board.controller;

import com.backend24.howtrip.board.vo.BoardFileVO;
import com.backend24.howtrip.board.vo.BoardTagVO;
import com.backend24.howtrip.board.vo.BoardVO;
import com.backend24.howtrip.board.vo.CommentVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	
    ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView viewBoard(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView inserBoard(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView editBoard(BoardVO boardVO, int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteBoard(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView incrementViews(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView incrementLikeCnt(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView getFilesByBoardId(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView addFile(BoardFileVO boardFileVO, int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView updateFile(BoardFileVO boardFileVO, int boardId, int fileId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteFile(int fileId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView getCommentsByBoardId(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView addComment(CommentVO commentVO, int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView updateComment(CommentVO commentVO, int boardId, int commentId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteComment(int commentId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    ModelAndView getTagsByBoardId(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView addTag(BoardTagVO boardTagVO, int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteTag(int tagId, HttpServletRequest request, HttpServletResponse response) throws Exception;
}