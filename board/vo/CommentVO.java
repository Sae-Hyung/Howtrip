package com.backend24.howtrip.board.vo;

import java.util.Date;

public class CommentVO {
	private int commentId;
	private String commentContent;
	private Date creareTime;
	private Date updateTime;
	private String userId;
	private int boardId;
	
	public CommentVO() {}
	
	public CommentVO (int commentId, String commentContent, Date creareTime, Date updateTime, String userId, int boardId) {
	  this.commentId = commentId;
	  this.commentContent = commentContent;
	  this.creareTime = creareTime;
	  this.updateTime = updateTime;
	  this.userId = userId;
	  this.boardId = boardId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCreareTime() {
		return creareTime;
	}
	public void setCreareTime(Date creareTime) {
		this.creareTime = creareTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	
}
