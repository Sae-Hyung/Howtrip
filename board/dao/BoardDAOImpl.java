package com.backend24.howtrip.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.backend24.howtrip.board.vo.BoardFileVO;
import com.backend24.howtrip.board.vo.BoardTagVO;
import com.backend24.howtrip.board.vo.BoardVO;
import com.backend24.howtrip.board.vo.CommentVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	 @Autowired
	    private SqlSession sqlSession;
	    
	    // 기본 게시판 관련 메서드
	    @Override
	    public List<BoardVO> selectAllBoards() throws DataAccessException {
	        return sqlSession.selectList("mapper.board.selectAllBoards");
	    }

	    @Override
	    public BoardVO selectBoardById(int boardId) throws DataAccessException {
	        return sqlSession.selectOne("mapper.board.selectBoardById", boardId);
	    }

	    @Override
	    public int insertBoard(BoardVO boardVO) throws DataAccessException {
	        return sqlSession.insert("mapper.board.insertBoard", boardVO);
	    }

	    @Override
	    public int updateBoard(BoardVO boardVO) throws DataAccessException {
	        return sqlSession.update("mapper.board.updateBoard", boardVO);
	    }

	    @Override
	    public int deleteBoard(int boardId) throws DataAccessException {
	        return sqlSession.delete("mapper.board.deleteBoard", boardId);
	    }

	    @Override
	    public int updateViews(int boardId) throws DataAccessException {
	        return sqlSession.update("mapper.board.updateViews", boardId);
	    }

	    @Override
	    public int updateLikeCnt(int boardId) throws DataAccessException {
	        return sqlSession.update("mapper.board.updateLikeCnt", boardId);
	    }

	    @Override
		public int getLikeCnt(int boardId) throws DataAccessException {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("mapper.board.getLikeCnt", boardId);
		}

		// 첨부파일 관련 메서드
	    @Override
	    public List<BoardFileVO> selectFilesByBoardId(int boardId) throws DataAccessException {
	        return sqlSession.selectList("mapper.board.selectFilesByBoardId", boardId);
	    }

	    @Override
	    public int insertFile(BoardFileVO boardFileVO) throws DataAccessException {
	        return sqlSession.insert("mapper.board.insertFile", boardFileVO);
	    }

	    @Override
	    public int updateFile(BoardFileVO boardFileVO) throws DataAccessException {
	        return sqlSession.update("mapper.board.updateFile", boardFileVO);
	    }

	    @Override
	    public int deleteFile(int fileId) throws DataAccessException {
	        return sqlSession.delete("mapper.board.deleteFile", fileId);
	    }

	    // 댓글 관련 메서드
	    @Override
	    public List<CommentVO> selectCommentsByBoardId(int boardId) throws DataAccessException {
	        return sqlSession.selectList("mapper.board.selectCommentsByBoardId", boardId);
	    }

	    @Override
	    public CommentVO selectCommentById(int commentId) throws DataAccessException {
	        return sqlSession.selectOne("mapper.board.selectCommentById", commentId);
	    }

	    @Override
	    public int insertComment(CommentVO commentVO) throws DataAccessException {
	        return sqlSession.insert("mapper.board.insertComment", commentVO);
	    }

	    @Override
	    public int updateComment(CommentVO commentVO) throws DataAccessException {
	        return sqlSession.update("mapper.board.updateComment", commentVO);
	    }

	    @Override
	    public int deleteComment(int commentId) throws DataAccessException {
	        return sqlSession.delete("mapper.board.deleteComment", commentId);
	    }

	    // 태그 관련 메서드
	    @Override
	    public List<BoardTagVO> selectTagsByBoardId(int boardId) throws DataAccessException {
	        return sqlSession.selectList("mapper.board.selectTagsByBoardId", boardId);
	    }

	    @Override
	    public int insertTag(BoardTagVO boardTagVO) throws DataAccessException {
	        return sqlSession.insert("mapper.board.insertTag", boardTagVO);
	    }

	    @Override
	    public int deleteTag(int tagId) throws DataAccessException {
	        return sqlSession.delete("mapper.board.deleteTag", tagId);
	    }
}
