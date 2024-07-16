package com.backend24.howtrip.community.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class BoardVO {
	private int boardId;
    private String title;
    private String boardContent;
    private int views;
    private int likeCnt;
    private Timestamp createdTime;
    private Timestamp updateTime;
    private String userId;
    private List<BoardFileVO> boardFiles; // 첨부파일 목록
    private List<BoardTagVO> tagNames; // 해시태그 목록
    private List<CommentVO> comments; //댓글 목록
   
  //기본생성자
  	public BoardVO() {
  		  
  	}
  	  
  	//전체 필드를 가진 생성자
  	public BoardVO(int boardId, String title, String boardContent, int views, int likeCnt, Timestamp createdTime, Timestamp updateTime, String userId) {
  		this.boardId = boardId;
  	    this.title = title;
  	    this.boardContent = boardContent;
  	    this.views = views;
  	    this.likeCnt = likeCnt;
  	    this.createdTime = createdTime;
  	    this.updateTime = updateTime;
  	    this.userId = userId;
   
  	}

  	public int getBoardId() {
  		return boardId;
  	}

  	public void setBoardId(int boardId) {
  		this.boardId = boardId;
  	}

  	public String getTitle() {
  		return title;
  	}

  	public void setTitle(String title) {
  		this.title = title;
  	}

  	public String getBoardContent() {
  		return boardContent;
  	}

  	public void setBoardContent(String boardContent) {
  		this.boardContent = boardContent;
  	}

  	public int getViews() {
  		return views;
  	}

  	public void setViews(int views) {
  		this.views = views;
  	}

  	public int getLikeCnt() {
  		return likeCnt;
  	}

  	public void setLikeCnt(int likeCnt) {
  		this.likeCnt = likeCnt;
  	}

  	public Timestamp getCreatedTime() {
  		return createdTime;
  	}

  	public void setCreatedTime(Timestamp createdTime) {
  		this.createdTime = createdTime;
  	}

  	public Timestamp getUpdateTime() {
  		return updateTime;
  	}

  	public void setUpdateTime(Timestamp updateTime) {
  		this.updateTime = updateTime;
  	}

  	public String getUserId() {
  		return userId;
  	}

  	public void setUserId(String userId) {
  		this.userId = userId;
  	}

  	public List<BoardFileVO> getBoardFiles() {
  	    return boardFiles;
  	}

  	public void setBoardFiles(List<BoardFileVO> boardFiles) {
  	    this.boardFiles = boardFiles;
  	}
  	public List<BoardTagVO> getTagNames() {
  		return tagNames;
  	}

  	public void setTagNames(List<BoardTagVO> tagNames) {
  		this.tagNames = tagNames;
  	}

  	public List<CommentVO> getComments() {
  		return comments;
  	}

  	public void setComments(List<CommentVO> comments) {
  		this.comments = comments;
  	}
     
}