package com.backend24.howtrip.community.controller;

import com.backend24.howtrip.community.service.BoardService;
import com.backend24.howtrip.community.vo.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/community")
public class BoardControllerImpl implements BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);

    @Autowired
    private BoardService boardService;

    @Override
    @RequestMapping(value = "/board.do", method = RequestMethod.GET)
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            List<BoardVO> boardList = boardService.listBoards();
            mav.addObject("boardList", boardList);
            mav.setViewName("community/board"); // 뷰 이름 설정
        } catch (Exception e) {
            logger.error("게시판 리스트 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "게시판 리스트 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }
    
    
    @Override
    @RequestMapping(value = "/addboard.do", method = RequestMethod.POST)
    public ModelAndView addBoard(@ModelAttribute("board") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.addBoard(boardVO);
            mav.addObject("message", "게시판이 추가되었습니다.");
            mav.setViewName("boardAddedView"); // 추가 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("게시판 추가에 실패하였습니다.", e);
            mav.addObject("error", "게시판 추가 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 추가 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }
    
    @Override
    @RequestMapping(value = "/removeboard.do", method = RequestMethod.DELETE)
    public ModelAndView removeBoard(@PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.removeBoard(boardId);
            mav.addObject("message", "게시판이 삭제되었습니다.");
            mav.setViewName("boardDeletedView"); // 삭제 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("게시판 삭제에 실패하였습니다.", e);
            mav.addObject("error", "게시판 삭제 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 삭제 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/searchboard.do", method = RequestMethod.GET)
    public ModelAndView viewBoard(@PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            BoardVO board = boardService.viewBoard(boardId);
            if (board != null) {
                mav.setViewName("boardDetail"); // JSP 파일 이름 (뷰 이름)을 설정합니다.
                mav.addObject("board", board); // 모델에 board 객체를 추가합니다.
            } else {
                mav.setViewName("error"); // 게시판을 찾을 수 없는 경우 에러 페이지로 이동합니다.
                mav.addObject("message", "해당 게시판을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            logger.error("게시판 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 예외 발생 시 에러 페이지로 이동합니다.
            mav.addObject("message", "게시판 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/editboard.do", method = RequestMethod.PUT)
    public ModelAndView editBoard(@ModelAttribute("board") BoardVO boardVO,
                                  @PathVariable("boardId") int boardId,
                                  HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardVO.setBoardId(boardId); // boardVO에 id 설정
            boardService.editBoard(boardVO);
            mav.setViewName("redirect:/community/board.do"); // 수정 후 게시판 리스트로 리다이렉트
            mav.addObject("message", "게시판이 수정되었습니다."); // 메시지를 모델에 추가
        } catch (Exception e) {
            logger.error("게시판 수정에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "게시판 수정 중 오류가 발생하였습니다.");
        }
        return mav;
    }
}    
