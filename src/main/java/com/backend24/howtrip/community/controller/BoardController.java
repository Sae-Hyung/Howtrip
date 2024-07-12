package com.backend24.howtrip.community.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.backend24.howtrip.community.vo.BoardVO;

public interface BoardController {
	public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response);
	public ModelAndView addBoard(@ModelAttribute("board") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView removeBoard(@PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView viewBoard(@PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView editBoard(@ModelAttribute("board") BoardVO boardVO,
            @PathVariable("boardId") int boardId,
            HttpServletRequest request, HttpServletResponse response);
	
}
