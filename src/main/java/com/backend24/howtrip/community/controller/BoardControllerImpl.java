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

import java.util.List;

@Controller
@RequestMapping("/community")
public class BoardControllerImpl implements BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);

    @Autowired
    private BoardService boardService;

    @Override
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        
        // 세션에서 user_id 가져오기
        MemberVO member = (MemberVO) session.getAttribute("member"); // loginController에서 memberVO객체를 member라는 이름으로 바인딩했다.
        String userId = member.getMemberId();
        
        logger.info("세션에서 가져온 user_id : " + userId);
        
        try {
            List<BoardVO> boardList = boardService.getAllBoards();
            mav.addObject("boardList", boardList);
            System.out.println("게시판 불러오기");
            mav.setViewName("community/board"); // 뷰 이름 설정
        } catch (Exception e) {
            logger.error("게시판 리스트 조회에 실패하였습니다.", e);
            mav.setViewName("error"); // 에러 발생 시 에러 페이지로 이동
            mav.addObject("message", "게시판 리스트 조회 중 오류가 발생하였습니다.");
        }
        return mav;
    }
    
    // 글쓰기 폼 보여주기 (GET 요청)
    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public ModelAndView showWriteForm(HttpSession session) {
        // 세션에서 user_id 가져오기
        MemberVO member = (MemberVO) session.getAttribute("member");
        String memberId = member.getMemberId();
        
        if (memberId == null) {
            return new ModelAndView("redirect:/member/loginForm.do"); // 세션이 없거나 사용자 아이디가 없으면 로그인 폼으로 이동
        } else {
            return new ModelAndView("boardWrite"); // 세션이 있고 사용자 아이디가 있으면 글쓰기 폼으로 이동
        }
    }
    
    // 글쓰기 처리 (POST 요청)
    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public ModelAndView insertBoard(@ModelAttribute("boardVO") BoardVO boardVO, HttpSession session) {
        ModelAndView mav = new ModelAndView();

        // 세션에서 user_id 가져오기
        MemberVO member = (MemberVO) session.getAttribute("member");
        String memberId = member.getMemberId();
        
        if (memberId == null) {
            mav.setViewName("redirect:/member/loginForm.do");
            return mav;
        }

        try {
            // 세션에서 가져온 사용자 ID를 설정
            boardVO.setUserId(memberId);

            // BoardVO 객체를 서비스를 통해 DB에 삽입
            boardService.insertBoard(boardVO);

            // 성공 시 목록 페이지로 리다이렉트
            mav.setViewName("redirect:/board/list");
        } catch (Exception e) {
            // 오류 발생 시 오류 페이지로 이동
            mav.addObject("error", "게시판 추가 중 오류가 발생하였습니다.");
            mav.setViewName("errorPage");
        }

        return mav;
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
    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
    public ModelAndView viewBoard(@PathVariable("boardId") int boardId,
                                  HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            BoardVO board = boardService.viewBoard(boardId);
            if (board != null) {
                mav.setViewName("community/boardDetail"); // JSP 파일 이름 (뷰 이름)을 설정합니다.
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
    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.PUT)
    public ModelAndView editBoard(@ModelAttribute("boardVO") BoardVO boardVO,
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
    @Override
    @RequestMapping(value = "/board/{boardId}/incrementViews", method = RequestMethod.POST)
    public ModelAndView incrementViews(@PathVariable("boardId") int boardId,
                                       HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            // 조회수 증가 로직
            boardService.incrementViews(boardId);

            // 추가적으로 필요한 작업이 있다면 모델에 추가
            mav.addObject("message", "조회수가 증가되었습니다.");

            // 성공 시 보여줄 뷰 설정
            mav.setViewName("redirect:/board/" + boardId); // 예시 URL, 실제로는 해당 게시글 상세 페이지로 리다이렉트

        } catch (Exception e) {
            logger.error("조회수 증가 중 오류 발생", e);
            mav.setViewName("error"); // 에러 페이지로 이동
            mav.addObject("error", "조회수 증가 중 오류가 발생하였습니다.");
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

	@Override
	public ModelAndView inserBoard(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}    
