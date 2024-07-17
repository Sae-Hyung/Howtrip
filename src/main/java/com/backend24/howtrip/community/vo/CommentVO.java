package com.backend24.howtrip.community.vo;

import java.sql.Timestamp;
import java.util.Date;

public class CommentVO {
	private int commentId;
	private String commentContent;
	private Timestamp createdTime;
	private Timestamp updateTime;
	private String memberId;
	private int boardId;
	
	public CommentVO() {}
	
	public CommentVO (int commentId, String commentContent, Timestamp createdTime, Timestamp updateTime, String userId, int boardId) {
	  this.commentId = commentId;
	  this.commentContent = commentContent;
	  this.createdTime = createdTime;
	  this.updateTime = updateTime;
	  this.memberId = userId;
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
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreareTime(Timestamp creareTime) {
		this.createdTime = createdTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	
}
