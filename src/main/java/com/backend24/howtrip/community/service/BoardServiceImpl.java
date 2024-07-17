package com.backend24.howtrip.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend24.howtrip.community.dao.BoardDAO;
import com.backend24.howtrip.community.vo.BoardFileVO;
import com.backend24.howtrip.community.vo.BoardTagVO;
import com.backend24.howtrip.community.vo.BoardVO;
import com.backend24.howtrip.community.vo.CommentVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {

	@Autowired
    private BoardDAO boardDAO;
    
    //기본게시판
    @Override
    public int insertBoard(BoardVO boardVO) throws DataAccessException {
        return boardDAO.insertBoard(boardVO);
    }

    @Override
    public int removeBoard(int boardId) throws DataAccessException {
        return boardDAO.deleteBoard(boardId);
    }

    @Override
    public BoardVO viewBoard(int boardId) throws DataAccessException {
        return boardDAO.selectBoardById(boardId);
    }

    @Override
    public int editBoard(BoardVO boardVO) throws DataAccessException {
        return boardDAO.updateBoard(boardVO);
    }

    @Override
    public List<BoardVO> getAllBoards() throws DataAccessException {
        return boardDAO.selectAllBoards();
    }

    @Override
    public int updateBoard(BoardVO boardVO) throws DataAccessException {
        return boardDAO.updateBoard(boardVO);
    }

    @Override
    public int deleteBoard(int boardId) throws DataAccessException {
        return boardDAO.deleteBoard(boardId);
    }

    @Override
    public void incrementViews(int boardId) throws DataAccessException {
        boardDAO.updateViews(boardId);
    }

    @Override
    public void incrementLikeCnt(int boardId) throws DataAccessException {
       boardDAO.updateLikeCnt(boardId);
    }
    @Override
    public int getLikeCnt(int boardId) throws DataAccessException {
        // 좋아요 수 조회 로직을 구현
    	return boardDAO.getLikeCnt(boardId);
    }

    //첨부파일
    @Override
    public List<BoardFileVO> getFilesByBoardId(int boardId) throws DataAccessException {
        return boardDAO.selectFilesByBoardId(boardId);
    }

    @Override
    public int addFile(BoardFileVO boardFileVO) throws DataAccessException {
        return boardDAO.insertFile(boardFileVO);
    }

    @Override
    public int updateFile(BoardFileVO boardFileVO) throws DataAccessException {
        return boardDAO.updateFile(boardFileVO);
    }

    @Override
    public int deleteFile(int fileId) throws DataAccessException {
        return boardDAO.deleteFile(fileId);
    }

    //댓글관련
    @Override
    public List<CommentVO> getCommentsByBoardId(int boardId) throws DataAccessException {
        return boardDAO.selectCommentsByBoardId(boardId);
    }

    @Override
    public CommentVO getCommentById(int commentId) throws DataAccessException {
        return boardDAO.selectCommentById(commentId);
    }

    @Override
    public int addComment(CommentVO commentVO) throws DataAccessException {
        return boardDAO.insertComment(commentVO);
    }

    @Override
    public int updateComment(CommentVO commentVO) throws DataAccessException {
        return boardDAO.updateComment(commentVO);
    }

    @Override
    public int deleteComment(int commentId) throws DataAccessException {
        return boardDAO.deleteComment(commentId);
    }

    //태그관련
    @Override
    public List<BoardTagVO> getTagsByBoardId(int boardId) throws DataAccessException {
        return boardDAO.selectTagsByBoardId(boardId);
    }

    @Override
    public int addTag(BoardTagVO boardTagVO) throws DataAccessException {
        return boardDAO.insertTag(boardTagVO);
    }

    @Override
    public int deleteTag(int tagId) throws DataAccessException {
        return boardDAO.deleteTag(tagId);
    }
}
