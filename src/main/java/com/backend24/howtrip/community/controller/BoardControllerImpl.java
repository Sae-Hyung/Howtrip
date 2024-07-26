package com.backend24.howtrip.community.controller;

import com.backend24.howtrip.community.service.BoardService;
import com.backend24.howtrip.community.vo.BoardFileVO;
import com.backend24.howtrip.community.vo.BoardTagVO;
import com.backend24.howtrip.community.vo.BoardVO;
import com.backend24.howtrip.community.vo.CommentVO;
import com.backend24.howtrip.member.vo.MemberVO;

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
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")
public class BoardControllerImpl implements BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);

    @Autowired
    private BoardService boardService;

    @Override
    @RequestMapping(value = "/board.do", method = RequestMethod.GET)
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        
        // 세션에서 user_id 가져오기
        MemberVO member = (MemberVO) session.getAttribute("member"); // loginController에서 memberVO객체를 member라는 이름으로 바인딩했다.
//        String memberId = member.getMemberId();
        
        logger.info("게시판 페이지 진입");
        
        logger.info("BoardControllerImpl - listBoards()메서드 MemberVO 객체의 값 : " + member);
//        logger.info("세션에서 가져온 memberId : " + memberId);
        
        
        List<BoardVO> boardList = boardService.getAllBoards();
        
//        System.out.println("boardList의 값 : " +boardList);
        
        mav.addObject("boardList", boardList);
        
        
        
        mav.setViewName("community/board"); // 뷰 이름 설정
       
        return mav;
    }
    
    // 로그인 여부 확인 (GET 요청)
    @ResponseBody
    @RequestMapping(value = "/writeCheck", method = RequestMethod.GET)
    public int writeCheck(HttpSession session) {
    	
        // 세션에서 member 가져오기
        MemberVO member = (MemberVO) session.getAttribute("member");
//        String memberId = member.getMemberId();
        
        if (member == null) // member 객체가 존재하지 않으면 0 반환
        	return 0;
        
        if (member.getMemberId() == null) // 아이디가 존재하지 않으면 0 반환
        	return 0;
        else // 아이디가 존재하면 1 반환
        	return 1;
    }
    
    // 글 작성 페이지로 이동
    @RequestMapping(value = "/board/writeForm", method = RequestMethod.GET)
    public ModelAndView writeForm(HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	
    	MemberVO memberVO = (MemberVO) session.getAttribute("member");
    	
    	mav.addObject("member", memberVO);
    	
    	mav.setViewName("community/boardWrite");

    	return mav;
    }
    
    // 글쓰기 처리 (POST 요청)
    @Override
    @ResponseBody
    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public int insertBoard(@ModelAttribute("boardVO") BoardVO boardVO, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("title의 값 : " + boardVO.getTitle());
        System.out.println("memberId의 값 : " + boardVO.getMemberId());
        System.out.println("boardContent의 값 : " + boardVO.getBoardContent());
        
        if (boardVO.getTitle() == null || boardVO.getTitle() == "") {
            return 0;
        } else if (boardVO.getBoardContent() == null || boardVO.getBoardContent() == "") {     	
        	return 1;
        }
     
        // Map 객체를 서비스를 통해 DB에 삽입
        boardService.insertBoard(boardVO);
           
        return 2;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.DELETE)
    public ModelAndView deleteBoard(@PathVariable("boardId") int boardId,
                                    HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.deleteBoard(boardId);
            mav.addObject("message", "게시판이 삭제되었습니다.");
            mav.setViewName("community/boardDeletedView"); // 삭제 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("게시판 삭제에 실패하였습니다.", e);
            mav.addObject("error", "게시판 삭제 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 삭제 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/board/viewCheck", method = RequestMethod.GET)
    public int viewCheck(HttpServletRequest request, HttpServletResponse response) {
    	int result;
    	System.out.println("BoardControllerImpl - viewCheck 메서드 진입");
        BoardVO board = boardService.findByBoardId(Integer.parseInt(request.getParameter("boardId")));
        
        if (board != null) {
        	result = 0;
        } else {
        	result = 1;
        }
        
        return result;
    }
    
    
    @RequestMapping(value = "/board/viewBoard/{boardId}", method = RequestMethod.GET)
    public ModelAndView viewBoard(@PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
    	System.out.println("BoardControllerImpl - viewBoard 메서드 진입");
    	BoardVO board = boardService.viewBoard(boardId);
    	
        mav.addObject("board", board); // 모델에 board 객체를 추가합니다.
        mav.setViewName("community/boardView"); // JSP 파일 이름 (뷰 이름)을 설정합니다.

    	return mav;
    }
    
    @RequestMapping(value = "/board/updateBoardForm", method = RequestMethod.POST)
    public ModelAndView updateBoardForm(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
    	
    	BoardVO boardVO = boardService.findByBoardId(Integer.parseInt(request.getParameter("boardId")));
    	
    	mav.addObject("board", boardVO);
    	mav.setViewName("community/updateBoard");
    	
    	return mav;
    }
    
    @Override
    @RequestMapping(value = "/board/updateBoard", method = RequestMethod.POST)
    public ModelAndView updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, @PathVariable("boardId") int boardId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        
        boardVO.setBoardId(boardId); // boardVO에 id 설정
        boardService.updateBoard(boardVO);
        mav.setViewName("redirect:/community/board.do"); // 수정 후 게시판 리스트로 리다이렉트
        mav.addObject("message", "게시판이 수정되었습니다."); // 메시지를 모델에 추가
        
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/files", method = RequestMethod.GET)
    public ModelAndView getFilesByBoardId(@PathVariable("boardId") int boardId,
                                          HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            List<BoardFileVO> files = boardService.getFilesByBoardId(boardId);
            mav.addObject("files", files);
            mav.setViewName("community/boardFiles"); // 뷰 이름 설정
        } catch (Exception e) {
            logger.error("첨부 파일 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "첨부 파일 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @RequestMapping(value = "/board/{boardId}/incrementLikeCnt", method = RequestMethod.POST)
    public ModelAndView incrementLikeCnt(@PathVariable("boardId") int boardId,
                                         HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            // 세션에서 사용자 정보 확인
            HttpSession session = request.getSession(false); // 세션이 없으면 새로 생성하지 않음
            if (session == null || session.getAttribute("userId") == null) {
                throw new IllegalStateException("로그인된 사용자만 좋아요를 할 수 있습니다.");
            }

            // 좋아요 수 증가 로직을 서비스 계층에서 처리
            boardService.incrementLikeCnt(boardId);

            // 좋아요 수를 다시 가져오는 예시 코드
            int updatedLikeCnt = boardService.getLikeCnt(boardId);

            // 모델에 데이터 추가
            mav.addObject("boardId", boardId);
            mav.addObject("likeCnt", updatedLikeCnt);
            mav.addObject("message", "좋아요가 증가되었습니다.");

            // 성공 시 보여줄 뷰 설정 (예: 해당 게시글 상세 페이지로 리다이렉트)
            mav.setViewName("redirect:/board/" + boardId);

        } catch (IllegalStateException e) {
            logger.error("좋아요 권한 없음", e);
            mav.setViewName("redirect:/login"); // 로그인 페이지로 리다이렉트
        } catch (Exception e) {
            logger.error("좋아요 증가 중 오류 발생", e);
            mav.setViewName("error"); // 에러 페이지로 이동
            mav.addObject("error", "좋아요 증가 중 오류가 발생하였습니다.");
        }
        return mav;
    }
    @Override
    @RequestMapping(value = "/board/{boardId}/files", method = RequestMethod.POST)
    public ModelAndView addFile(@ModelAttribute("boardFileVO") BoardFileVO boardFileVO,
                                @PathVariable("boardId") int boardId,
                                HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.addFile(boardFileVO);
            mav.addObject("message", "첨부 파일이 추가되었습니다.");
            mav.setViewName("community/fileAddedView"); // 추가 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("첨부 파일 추가에 실패하였습니다.", e);
            mav.addObject("error", "첨부 파일 추가 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 추가 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/files/{fileId}", method = RequestMethod.PUT)
    public ModelAndView updateFile(@ModelAttribute("boardFileVO") BoardFileVO boardFileVO,
                                   @PathVariable("boardId") int boardId,
                                   @PathVariable("fileId") int fileId,
                                   HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardFileVO.setFileId(fileId); // fileId 설정
            boardService.updateFile(boardFileVO);
            mav.setViewName("redirect:/community/board/{boardId}/files"); // 수정 후 파일 목록으로 리다이렉트
            mav.addObject("message", "첨부 파일이 수정되었습니다."); // 메시지를 모델에 추가
        } catch (Exception e) {
            logger.error("첨부 파일 수정에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "첨부 파일 수정 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/files/{fileId}", method = RequestMethod.DELETE)
    public ModelAndView deleteFile(@PathVariable("fileId") int fileId,
                                   HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.deleteFile(fileId);
            mav.addObject("message", "첨부 파일이 삭제되었습니다.");
            mav.setViewName("community/fileDeletedView"); // 삭제 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("첨부 파일 삭제에 실패하였습니다.", e);
            mav.addObject("error", "첨부 파일 삭제 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 삭제 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/comments", method = RequestMethod.GET)
    public ModelAndView getCommentsByBoardId(@PathVariable("boardId") int boardId,
                                             HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            List<CommentVO> comments = boardService.getCommentsByBoardId(boardId);
            mav.addObject("comments", comments);
            mav.setViewName("community/boardComments"); // 뷰 이름 설정
        } catch (Exception e) {
            logger.error("댓글 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "댓글 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/comments", method = RequestMethod.POST)
    public ModelAndView addComment(@ModelAttribute("commentVO") CommentVO commentVO,
                                   @PathVariable("boardId") int boardId,
                                   HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.addComment(commentVO);
            mav.addObject("message", "댓글이 추가되었습니다.");
            mav.setViewName("community/commentAddedView"); // 추가 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("댓글 추가에 실패하였습니다.", e);
            mav.addObject("error", "댓글 추가 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 추가 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/comments/{commentId}", method = RequestMethod.PUT)
    public ModelAndView updateComment(@ModelAttribute("commentVO") CommentVO commentVO,
                                      @PathVariable("boardId") int boardId,
                                      @PathVariable("commentId") int commentId,
                                      HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            commentVO.setCommentId(commentId); // commentId 설정
            boardService.updateComment(commentVO);
            mav.setViewName("redirect:/community/board/{boardId}/comments"); // 수정 후 댓글 목록으로 리다이렉트
            mav.addObject("message", "댓글이 수정되었습니다."); // 메시지를 모델에 추가
        } catch (Exception e) {
            logger.error("댓글 수정에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "댓글 수정 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/comments/{commentId}", method = RequestMethod.DELETE)
    public ModelAndView deleteComment(@PathVariable("commentId") int commentId,
                                      HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.deleteComment(commentId);
            mav.addObject("message", "댓글이 삭제되었습니다.");
            mav.setViewName("community/commentDeletedView"); // 삭제 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("댓글 삭제에 실패하였습니다.", e);
            mav.addObject("error", "댓글 삭제 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 삭제 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/tags", method = RequestMethod.GET)
    public ModelAndView getTagsByBoardId(@PathVariable("boardId") int boardId,
                                         HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            List<BoardTagVO> tags = boardService.getTagsByBoardId(boardId);
            mav.addObject("tags", tags);
            mav.setViewName("community/boardTags"); // 뷰 이름 설정
        } catch (Exception e) {
            logger.error("태그 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "태그 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/tags", method = RequestMethod.POST)
    public ModelAndView addTag(@ModelAttribute("boardTagVO") BoardTagVO boardTagVO,
                               @PathVariable("boardId") int boardId,
                               HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.addTag(boardTagVO);
            mav.addObject("message", "태그가 추가되었습니다.");
            mav.setViewName("community/tagAddedView"); // 추가 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("태그 추가에 실패하였습니다.", e);
            mav.addObject("error", "태그 추가 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 추가 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }

    @Override
    @RequestMapping(value = "/board/{boardId}/tags/{tagId}", method = RequestMethod.DELETE)
    public ModelAndView deleteTag(@PathVariable("tagId") int tagId,
                                  HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            boardService.deleteTag(tagId);
            mav.addObject("message", "태그가 삭제되었습니다.");
            mav.setViewName("community/tagDeletedView"); // 삭제 성공 시 보여줄 뷰 이름 설정
        } catch (Exception e) {
            logger.error("태그 삭제에 실패하였습니다.", e);
            mav.addObject("error", "태그 삭제 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage"); // 삭제 실패 시 보여줄 뷰 이름 설정
        }
        return mav;
    }
}    
