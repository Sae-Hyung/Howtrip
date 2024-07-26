package com.backend24.howtrip.community.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.backend24.howtrip.community.vo.BoardFileVO;
import com.backend24.howtrip.community.vo.BoardTagVO;
import com.backend24.howtrip.community.vo.BoardVO;
import com.backend24.howtrip.community.vo.CommentVO;

public interface BoardController {
	
	ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception;
    int viewCheck(HttpServletRequest request, HttpServletResponse response) throws Exception;
    int insertBoard(BoardVO boardVO, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView updateBoard(BoardVO boardVO, int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView deleteBoard(int boardId, HttpServletRequest request, HttpServletResponse response) throws Exception;
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
